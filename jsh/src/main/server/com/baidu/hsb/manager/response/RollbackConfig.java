/**
 * Baidu.com,Inc.
 * Copyright (c) 2000-2013 All Rights Reserved.
 */
package com.baidu.hsb.manager.response;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import com.baidu.hsb.HeisenbergCluster;
import com.baidu.hsb.HeisenbergConfig;
import com.baidu.hsb.HeisenbergServer;
import com.baidu.hsb.config.ErrorCode;
import com.baidu.hsb.config.model.config.DataSourceConfig;
import com.baidu.hsb.config.model.config.QuarantineConfig;
import com.baidu.hsb.config.model.config.SchemaConfig;
import com.baidu.hsb.config.model.config.UserConfig;
import com.baidu.hsb.manager.ManagerConnection;
import com.baidu.hsb.mysql.MySQLDataNode;
import com.baidu.hsb.mysql.MySQLDataSource;
import com.baidu.hsb.net.mysql.OkPacket;

/**
 * @author xiongzhao@baidu.com
 */
public final class RollbackConfig {
    private static final Logger LOGGER = Logger.getLogger(RollbackConfig.class);

    public static void execute(ManagerConnection c) {
        final ReentrantLock lock = HeisenbergServer.getInstance().getConfig().getLock();
        lock.lock();
        try {
            if (rollback()) {
                StringBuilder s = new StringBuilder();
                s.append(c).append("Rollback config success by manager");
                LOGGER.warn(s.toString());
                OkPacket ok = new OkPacket();
                ok.packetId = 1;
                ok.affectedRows = 1;
                ok.serverStatus = 2;
                ok.message = "Rollback config success".getBytes();
                ok.write(c);
            } else {
                c.writeErrMessage(ErrorCode.ER_YES, "Rollback config failure");
            }
        } finally {
            lock.unlock();
        }
    }

    private static boolean rollback() {
        HeisenbergConfig conf = HeisenbergServer.getInstance().getConfig();
        Map<String, UserConfig> users = conf.getBackupUsers();
        Map<String, SchemaConfig> schemas = conf.getBackupSchemas();
        Map<String, MySQLDataNode> dataNodes = conf.getBackupDataNodes();
        Map<String, DataSourceConfig> dataSources = conf.getBackupDataSources();
        HeisenbergCluster cluster = conf.getBackupCluster();
        QuarantineConfig quarantine = conf.getBackupQuarantine();

        // ?????????????????????
        if (!conf.canRollback()) {
            return false;
        }

        // ???????????????????????????pool??????????????????????????????????????????????????????1???
        boolean rollbackStatus = true;
        Map<String, MySQLDataNode> cNodes = conf.getDataNodes();
        for (MySQLDataNode dn : dataNodes.values()) {
            MySQLDataNode cdn = cNodes.get(dn.getName());
            if (cdn != null && cdn.getSource() != null) {
                int size = Math.min(cdn.getSource().getIdleCount(), dn.getConfig().getPoolSize());
                dn.init(size > 0 ? size : 1, dn.getActivedIndex());
            } else {
                dn.init(1, dn.getActivedIndex());
            }
            if (!dn.isInitSuccess()) {
                rollbackStatus = false;
                break;
            }
        }
        // ?????????????????????????????????????????????????????????
        if (!rollbackStatus) {
            for (MySQLDataNode dn : dataNodes.values()) {
                MySQLDataSource ds = dn.getSource();
                if (ds != null) {
                    ds.clear();
                }
            }
            return false;
        }

        // ????????????
        conf.rollback(users, schemas, dataNodes, dataSources, cluster, quarantine);

        // ??????????????????
        for (MySQLDataNode dn : cNodes.values()) {
            MySQLDataSource ds = dn.getSource();
            if (ds != null) {
                ds.clear();
            }
        }

        return true;
    }

}
