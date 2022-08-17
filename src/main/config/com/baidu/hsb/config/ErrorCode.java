/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.hsb.config;

/**
 * @author xiongzhao@baidu.com
 */
public interface ErrorCode {

    // cobar error code
    int ERR_OPEN_SOCKET                            = 3001;
    int ERR_CONNECT_SOCKET                         = 3002;
    int ERR_FINISH_CONNECT                         = 3003;
    int ERR_REGISTER                               = 3004;
    int ERR_READ                                   = 3005;
    int ERR_PUT_WRITE_QUEUE                        = 3006;
    int ERR_WRITE_BY_EVENT                         = 3007;
    int ERR_WRITE_BY_QUEUE                         = 3008;
    int ERR_HANDLE_DATA                            = 3009;

    // mysql error code
    int ER_HASHCHK                                 = 1000;
    int ER_NISAMCHK                                = 1001;
    int ER_NO                                      = 1002;
    int ER_YES                                     = 1003;
    int ER_CANT_CREATE_FILE                        = 1004;
    int ER_CANT_CREATE_TABLE                       = 1005;
    int ER_CANT_CREATE_DB                          = 1006;
    int ER_DB_CREATE_EXISTS                        = 1007;
    int ER_DB_DROP_EXISTS                          = 1008;
    int ER_DB_DROP_DELETE                          = 1009;
    int ER_DB_DROP_RMDIR                           = 1010;
    int ER_CANT_DELETE_FILE                        = 1011;
    int ER_CANT_FIND_SYSTEM_REC                    = 1012;
    int ER_CANT_GET_STAT                           = 1013;
    int ER_CANT_GET_WD                             = 1014;
    int ER_CANT_LOCK                               = 1015;
    int ER_CANT_OPEN_FILE                          = 1016;
    int ER_FILE_NOT_FOUND                          = 1017;
    int ER_CANT_READ_DIR                           = 1018;
    int ER_CANT_SET_WD                             = 1019;
    int ER_CHECKREAD                               = 1020;
    int ER_DISK_FULL                               = 1021;
    int ER_DUP_KEY                                 = 1022;
    int ER_ERROR_ON_CLOSE                          = 1023;
    int ER_ERROR_ON_READ                           = 1024;
    int ER_ERROR_ON_RENAME                         = 1025;
    int ER_ERROR_ON_WRITE                          = 1026;
    int ER_FILE_USED                               = 1027;
    int ER_FILSORT_ABORT                           = 1028;
    int ER_FORM_NOT_FOUND                          = 1029;
    int ER_GET_ERRNO                               = 1030;
    int ER_ILLEGAL_HA                              = 1031;
    int ER_KEY_NOT_FOUND                           = 1032;
    int ER_NOT_FORM_FILE                           = 1033;
    int ER_NOT_KEYFILE                             = 1034;
    int ER_OLD_KEYFILE                             = 1035;
    int ER_OPEN_AS_READONLY                        = 1036;
    int ER_OUTOFMEMORY                             = 1037;
    int ER_OUT_OF_SORTMEMORY                       = 1038;
    int ER_UNEXPECTED_EOF                          = 1039;
    int ER_CON_COUNT_ERROR                         = 1040;
    int ER_OUT_OF_RESOURCES                        = 1041;
    int ER_BAD_HOST_ERROR                          = 1042;
    int ER_HANDSHAKE_ERROR                         = 1043;
    int ER_DBACCESS_DENIED_ERROR                   = 1044;
    int ER_ACCESS_DENIED_ERROR                     = 1045;
    int ER_NO_DB_ERROR                             = 1046;
    int ER_UNKNOWN_COM_ERROR                       = 1047;
    int ER_BAD_NULL_ERROR                          = 1048;
    int ER_BAD_DB_ERROR                            = 1049;
    int ER_TABLE_EXISTS_ERROR                      = 1050;
    int ER_BAD_TABLE_ERROR                         = 1051;
    int ER_NON_UNIQ_ERROR                          = 1052;
    int ER_SERVER_SHUTDOWN                         = 1053;
    int ER_BAD_FIELD_ERROR                         = 1054;
    int ER_WRONG_FIELD_WITH_GROUP                  = 1055;
    int ER_WRONG_GROUP_FIELD                       = 1056;
    int ER_WRONG_SUM_SELECT                        = 1057;
    int ER_WRONG_VALUE_COUNT                       = 1058;
    int ER_TOO_LONG_IDENT                          = 1059;
    int ER_DUP_FIELDNAME                           = 1060;
    int ER_DUP_KEYNAME                             = 1061;
    int ER_DUP_ENTRY                               = 1062;
    int ER_WRONG_FIELD_SPEC                        = 1063;
    int ER_PARSE_ERROR                             = 1064;
    int ER_EMPTY_QUERY                             = 1065;
    int ER_NONUNIQ_TABLE                           = 1066;
    int ER_INVALID_DEFAULT                         = 1067;
    int ER_MULTIPLE_PRI_KEY                        = 1068;
    int ER_TOO_MANY_KEYS                           = 1069;
    int ER_TOO_MANY_KEY_PARTS                      = 1070;
    int ER_TOO_LONG_KEY                            = 1071;
    int ER_KEY_COLUMN_DOES_NOT_EXITS               = 1072;
    int ER_BLOB_USED_AS_KEY                        = 1073;
    int ER_TOO_BIG_FIELDLENGTH                     = 1074;
    int ER_WRONG_AUTO_KEY                          = 1075;
    int ER_READY                                   = 1076;
    int ER_NORMAL_SHUTDOWN                         = 1077;
    int ER_GOT_SIGNAL                              = 1078;
    int ER_SHUTDOWN_COMPLETE                       = 1079;
    int ER_FORCING_CLOSE                           = 1080;
    int ER_IPSOCK_ERROR                            = 1081;
    int ER_NO_SUCH_INDEX                           = 1082;
    int ER_WRONG_FIELD_TERMINATORS                 = 1083;
    int ER_BLOBS_AND_NO_TERMINATED                 = 1084;
    int ER_TEXTFILE_NOT_READABLE                   = 1085;
    int ER_FILE_EXISTS_ERROR                       = 1086;
    int ER_LOAD_INFO                               = 1087;
    int ER_ALTER_INFO                              = 1088;
    int ER_WRONG_SUB_KEY                           = 1089;
    int ER_CANT_REMOVE_ALL_FIELDS                  = 1090;
    int ER_CANT_DROP_FIELD_OR_KEY                  = 1091;
    int ER_INSERT_INFO                             = 1092;
    int ER_UPDATE_TABLE_USED                       = 1093;
    int ER_NO_SUCH_THREAD                          = 1094;
    int ER_KILL_DENIED_ERROR                       = 1095;
    int ER_NO_TABLES_USED                          = 1096;
    int ER_TOO_BIG_SET                             = 1097;
    int ER_NO_UNIQUE_LOGFILE                       = 1098;
    int ER_TABLE_NOT_LOCKED_FOR_WRITE              = 1099;
    int ER_TABLE_NOT_LOCKED                        = 1100;
    int ER_BLOB_CANT_HAVE_DEFAULT                  = 1101;
    int ER_WRONG_DB_NAME                           = 1102;
    int ER_WRONG_TABLE_NAME                        = 1103;
    int ER_TOO_BIG_SELECT                          = 1104;
    int ER_UNKNOWN_ERROR                           = 1105;
    int ER_UNKNOWN_PROCEDURE                       = 1106;
    int ER_WRONG_PARAMCOUNT_TO_PROCEDURE           = 1107;
    int ER_WRONG_PARAMETERS_TO_PROCEDURE           = 1108;
    int ER_UNKNOWN_TABLE                           = 1109;
    int ER_FIELD_SPECIFIED_TWICE                   = 1110;
    int ER_INVALID_GROUP_FUNC_USE                  = 1111;
    int ER_UNSUPPORTED_EXTENSION                   = 1112;
    int ER_TABLE_MUST_HAVE_COLUMNS                 = 1113;
    int ER_RECORD_FILE_FULL                        = 1114;
    int ER_UNKNOWN_CHARACTER_SET                   = 1115;
    int ER_TOO_MANY_TABLES                         = 1116;
    int ER_TOO_MANY_FIELDS                         = 1117;
    int ER_TOO_BIG_ROWSIZE                         = 1118;
    int ER_STACK_OVERRUN                           = 1119;
    int ER_WRONG_OUTER_JOIN                        = 1120;
    int ER_NULL_COLUMN_IN_INDEX                    = 1121;
    int ER_CANT_FIND_UDF                           = 1122;
    int ER_CANT_INITIALIZE_UDF                     = 1123;
    int ER_UDF_NO_PATHS                            = 1124;
    int ER_UDF_EXISTS                              = 1125;
    int ER_CANT_OPEN_LIBRARY                       = 1126;
    int ER_CANT_FIND_DL_ENTRY                      = 1127;
    int ER_FUNCTION_NOT_DEFINED                    = 1128;
    int ER_HOST_IS_BLOCKED                         = 1129;
    int ER_HOST_NOT_PRIVILEGED                     = 1130;
    int ER_PASSWORD_ANONYMOUS_USER                 = 1131;
    int ER_PASSWORD_NOT_ALLOWED                    = 1132;
    int ER_PASSWORD_NO_MATCH                       = 1133;
    int ER_UPDATE_INFO                             = 1134;
    int ER_CANT_CREATE_THREAD                      = 1135;
    int ER_WRONG_VALUE_COUNT_ON_ROW                = 1136;
    int ER_CANT_REOPEN_TABLE                       = 1137;
    int ER_INVALID_USE_OF_NULL                     = 1138;
    int ER_REGEXP_ERROR                            = 1139;
    int ER_MIX_OF_GROUP_FUNC_AND_FIELDS            = 1140;
    int ER_NONEXISTING_GRANT                       = 1141;
    int ER_TABLEACCESS_DENIED_ERROR                = 1142;
    int ER_COLUMNACCESS_DENIED_ERROR               = 1143;
    int ER_ILLEGAL_GRANT_FOR_TABLE                 = 1144;
    int ER_GRANT_WRONG_HOST_OR_USER                = 1145;
    int ER_NO_SUCH_TABLE                           = 1146;
    int ER_NONEXISTING_TABLE_GRANT                 = 1147;
    int ER_NOT_ALLOWED_COMMAND                     = 1148;
    int ER_SYNTAX_ERROR                            = 1149;
    int ER_DELAYED_CANT_CHANGE_LOCK                = 1150;
    int ER_TOO_MANY_DELAYED_THREADS                = 1151;
    int ER_ABORTING_CONNECTION                     = 1152;
    int ER_NET_PACKET_TOO_LARGE                    = 1153;
    int ER_NET_READ_ERROR_FROM_PIPE                = 1154;
    int ER_NET_FCNTL_ERROR                         = 1155;
    int ER_NET_PACKETS_OUT_OF_ORDER                = 1156;
    int ER_NET_UNCOMPRESS_ERROR                    = 1157;
    int ER_NET_READ_ERROR                          = 1158;
    int ER_NET_READ_INTERRUPTED                    = 1159;
    int ER_NET_ERROR_ON_WRITE                      = 1160;
    int ER_NET_WRITE_INTERRUPTED                   = 1161;
    int ER_TOO_LONG_STRING                         = 1162;
    int ER_TABLE_CANT_HANDLE_BLOB                  = 1163;
    int ER_TABLE_CANT_HANDLE_AUTO_INCREMENT        = 1164;
    int ER_DELAYED_INSERT_TABLE_LOCKED             = 1165;
    int ER_WRONG_COLUMN_NAME                       = 1166;
    int ER_WRONG_KEY_COLUMN                        = 1167;
    int ER_WRONG_MRG_TABLE                         = 1168;
    int ER_DUP_UNIQUE                              = 1169;
    int ER_BLOB_KEY_WITHOUT_LENGTH                 = 1170;
    int ER_PRIMARY_CANT_HAVE_NULL                  = 1171;
    int ER_TOO_MANY_ROWS                           = 1172;
    int ER_REQUIRES_PRIMARY_KEY                    = 1173;
    int ER_NO_RAID_COMPILED                        = 1174;
    int ER_UPDATE_WITHOUT_KEY_IN_SAFE_MODE         = 1175;
    int ER_KEY_DOES_NOT_EXITS                      = 1176;
    int ER_CHECK_NO_SUCH_TABLE                     = 1177;
    int ER_CHECK_NOT_IMPLEMENTED                   = 1178;
    int ER_CANT_DO_THIS_DURING_AN_TRANSACTION      = 1179;
    int ER_ERROR_DURING_COMMIT                     = 1180;
    int ER_ERROR_DURING_ROLLBACK                   = 1181;
    int ER_ERROR_DURING_FLUSH_LOGS                 = 1182;
    int ER_ERROR_DURING_CHECKPOINT                 = 1183;
    int ER_NEW_ABORTING_CONNECTION                 = 1184;
    int ER_DUMP_NOT_IMPLEMENTED                    = 1185;
    int ER_FLUSH_MASTER_BINLOG_CLOSED              = 1186;
    int ER_INDEX_REBUILD                           = 1187;
    int ER_MASTER                                  = 1188;
    int ER_MASTER_NET_READ                         = 1189;
    int ER_MASTER_NET_WRITE                        = 1190;
    int ER_FT_MATCHING_KEY_NOT_FOUND               = 1191;
    int ER_LOCK_OR_ACTIVE_TRANSACTION              = 1192;
    int ER_UNKNOWN_SYSTEM_VARIABLE                 = 1193;
    int ER_CRASHED_ON_USAGE                        = 1194;
    int ER_CRASHED_ON_REPAIR                       = 1195;
    int ER_WARNING_NOT_COMPLETE_ROLLBACK           = 1196;
    int ER_TRANS_CACHE_FULL                        = 1197;
    int ER_SLAVE_MUST_STOP                         = 1198;
    int ER_SLAVE_NOT_RUNNING                       = 1199;
    int ER_BAD_SLAVE                               = 1200;
    int ER_MASTER_INFO                             = 1201;
    int ER_SLAVE_THREAD                            = 1202;
    int ER_TOO_MANY_USER_CONNECTIONS               = 1203;
    int ER_SET_CONSTANTS_ONLY                      = 1204;
    int ER_LOCK_WAIT_TIMEOUT                       = 1205;
    int ER_LOCK_TABLE_FULL                         = 1206;
    int ER_READ_ONLY_TRANSACTION                   = 1207;
    int ER_DROP_DB_WITH_READ_LOCK                  = 1208;
    int ER_CREATE_DB_WITH_READ_LOCK                = 1209;
    int ER_WRONG_ARGUMENTS                         = 1210;
    int ER_NO_PERMISSION_TO_CREATE_USER            = 1211;
    int ER_UNION_TABLES_IN_DIFFERENT_DIR           = 1212;
    int ER_LOCK_DEADLOCK                           = 1213;
    int ER_TABLE_CANT_HANDLE_FT                    = 1214;
    int ER_CANNOT_ADD_FOREIGN                      = 1215;
    int ER_NO_REFERENCED_ROW                       = 1216;
    int ER_ROW_IS_REFERENCED                       = 1217;
    int ER_CONNECT_TO_MASTER                       = 1218;
    int ER_QUERY_ON_MASTER                         = 1219;
    int ER_ERROR_WHEN_EXECUTING_COMMAND            = 1220;
    int ER_WRONG_USAGE                             = 1221;
    int ER_WRONG_NUMBER_OF_COLUMNS_IN_SELECT       = 1222;
    int ER_CANT_UPDATE_WITH_READLOCK               = 1223;
    int ER_MIXING_NOT_ALLOWED                      = 1224;
    int ER_DUP_ARGUMENT                            = 1225;
    int ER_USER_LIMIT_REACHED                      = 1226;
    int ER_SPECIFIC_ACCESS_DENIED_ERROR            = 1227;
    int ER_LOCAL_VARIABLE                          = 1228;
    int ER_GLOBAL_VARIABLE                         = 1229;
    int ER_NO_DEFAULT                              = 1230;
    int ER_WRONG_VALUE_FOR_VAR                     = 1231;
    int ER_WRONG_TYPE_FOR_VAR                      = 1232;
    int ER_VAR_CANT_BE_READ                        = 1233;
    int ER_CANT_USE_OPTION_HERE                    = 1234;
    int ER_NOT_SUPPORTED_YET                       = 1235;
    int ER_MASTER_FATAL_ERROR_READING_BINLOG       = 1236;
    int ER_SLAVE_IGNORED_TABLE                     = 1237;
    int ER_INCORRECT_GLOBAL_LOCAL_VAR              = 1238;
    int ER_WRONG_FK_DEF                            = 1239;
    int ER_KEY_REF_DO_NOT_MATCH_TABLE_REF          = 1240;
    int ER_OPERAND_COLUMNS                         = 1241;
    int ER_SUBQUERY_NO_1_ROW                       = 1242;
    int ER_UNKNOWN_STMT_HANDLER                    = 1243;
    int ER_CORRUPT_HELP_DB                         = 1244;
    int ER_CYCLIC_REFERENCE                        = 1245;
    int ER_AUTO_CONVERT                            = 1246;
    int ER_ILLEGAL_REFERENCE                       = 1247;
    int ER_DERIVED_MUST_HAVE_ALIAS                 = 1248;
    int ER_SELECT_REDUCED                          = 1249;
    int ER_TABLENAME_NOT_ALLOWED_HERE              = 1250;
    int ER_NOT_SUPPORTED_AUTH_MODE                 = 1251;
    int ER_SPATIAL_CANT_HAVE_NULL                  = 1252;
    int ER_COLLATION_CHARSET_MISMATCH              = 1253;
    int ER_SLAVE_WAS_RUNNING                       = 1254;
    int ER_SLAVE_WAS_NOT_RUNNING                   = 1255;
    int ER_TOO_BIG_FOR_UNCOMPRESS                  = 1256;
    int ER_ZLIB_Z_MEM_ERROR                        = 1257;
    int ER_ZLIB_Z_BUF_ERROR                        = 1258;
    int ER_ZLIB_Z_DATA_ERROR                       = 1259;
    int ER_CUT_VALUE_GROUP_CONCAT                  = 1260;
    int ER_WARN_TOO_FEW_RECORDS                    = 1261;
    int ER_WARN_TOO_MANY_RECORDS                   = 1262;
    int ER_WARN_NULL_TO_NOTNULL                    = 1263;
    int ER_WARN_DATA_OUT_OF_RANGE                  = 1264;
    int WARN_DATA_TRUNCATED                        = 1265;
    int ER_WARN_USING_OTHER_HANDLER                = 1266;
    int ER_CANT_AGGREGATE_2COLLATIONS              = 1267;
    int ER_DROP_USER                               = 1268;
    int ER_REVOKE_GRANTS                           = 1269;
    int ER_CANT_AGGREGATE_3COLLATIONS              = 1270;
    int ER_CANT_AGGREGATE_NCOLLATIONS              = 1271;
    int ER_VARIABLE_IS_NOT_STRUCT                  = 1272;
    int ER_UNKNOWN_COLLATION                       = 1273;
    int ER_SLAVE_IGNORED_SSL_PARAMS                = 1274;
    int ER_SERVER_IS_IN_SECURE_AUTH_MODE           = 1275;
    int ER_WARN_FIELD_RESOLVED                     = 1276;
    int ER_BAD_SLAVE_UNTIL_COND                    = 1277;
    int ER_MISSING_SKIP_SLAVE                      = 1278;
    int ER_UNTIL_COND_IGNORED                      = 1279;
    int ER_WRONG_NAME_FOR_INDEX                    = 1280;
    int ER_WRONG_NAME_FOR_CATALOG                  = 1281;
    int ER_WARN_QC_RESIZE                          = 1282;
    int ER_BAD_FT_COLUMN                           = 1283;
    int ER_UNKNOWN_KEY_CACHE                       = 1284;
    int ER_WARN_HOSTNAME_WONT_WORK                 = 1285;
    int ER_UNKNOWN_STORAGE_ENGINE                  = 1286;
    int ER_WARN_DEPRECATED_SYNTAX                  = 1287;
    int ER_NON_UPDATABLE_TABLE                     = 1288;
    int ER_FEATURE_DISABLED                        = 1289;
    int ER_OPTION_PREVENTS_STATEMENT               = 1290;
    int ER_DUPLICATED_VALUE_IN_TYPE                = 1291;
    int ER_TRUNCATED_WRONG_VALUE                   = 1292;
    int ER_TOO_MUCH_AUTO_TIMESTAMP_COLS            = 1293;
    int ER_INVALID_ON_UPDATE                       = 1294;
    int ER_UNSUPPORTED_PS                          = 1295;
    int ER_GET_ERRMSG                              = 1296;
    int ER_GET_TEMPORARY_ERRMSG                    = 1297;
    int ER_UNKNOWN_TIME_ZONE                       = 1298;
    int ER_WARN_INVALID_TIMESTAMP                  = 1299;
    int ER_INVALID_CHARACTER_STRING                = 1300;
    int ER_WARN_ALLOWED_PACKET_OVERFLOWED          = 1301;
    int ER_CONFLICTING_DECLARATIONS                = 1302;
    int ER_SP_NO_RECURSIVE_CREATE                  = 1303;
    int ER_SP_ALREADY_EXISTS                       = 1304;
    int ER_SP_DOES_NOT_EXIST                       = 1305;
    int ER_SP_DROP_FAILED                          = 1306;
    int ER_SP_STORE_FAILED                         = 1307;
    int ER_SP_LILABEL_MISMATCH                     = 1308;
    int ER_SP_LABEL_REDEFINE                       = 1309;
    int ER_SP_LABEL_MISMATCH                       = 1310;
    int ER_SP_UNINIT_VAR                           = 1311;
    int ER_SP_BADSELECT                            = 1312;
    int ER_SP_BADRETURN                            = 1313;
    int ER_SP_BADSTATEMENT                         = 1314;
    int ER_UPDATE_LOG_DEPRECATED_IGNORED           = 1315;
    int ER_UPDATE_LOG_DEPRECATED_TRANSLATED        = 1316;
    int ER_QUERY_INTERRUPTED                       = 1317;
    int ER_SP_WRONG_NO_OF_ARGS                     = 1318;
    int ER_SP_COND_MISMATCH                        = 1319;
    int ER_SP_NORETURN                             = 1320;
    int ER_SP_NORETURNEND                          = 1321;
    int ER_SP_BAD_CURSOR_QUERY                     = 1322;
    int ER_SP_BAD_CURSOR_SELECT                    = 1323;
    int ER_SP_CURSOR_MISMATCH                      = 1324;
    int ER_SP_CURSOR_ALREADY_OPEN                  = 1325;
    int ER_SP_CURSOR_NOT_OPEN                      = 1326;
    int ER_SP_UNDECLARED_VAR                       = 1327;
    int ER_SP_WRONG_NO_OF_FETCH_ARGS               = 1328;
    int ER_SP_FETCH_NO_DATA                        = 1329;
    int ER_SP_DUP_PARAM                            = 1330;
    int ER_SP_DUP_VAR                              = 1331;
    int ER_SP_DUP_COND                             = 1332;
    int ER_SP_DUP_CURS                             = 1333;
    int ER_SP_CANT_ALTER                           = 1334;
    int ER_SP_SUBSELECT_NYI                        = 1335;
    int ER_STMT_NOT_ALLOWED_IN_SF_OR_TRG           = 1336;
    int ER_SP_VARCOND_AFTER_CURSHNDLR              = 1337;
    int ER_SP_CURSOR_AFTER_HANDLER                 = 1338;
    int ER_SP_CASE_NOT_FOUND                       = 1339;
    int ER_FPARSER_TOO_BIG_FILE                    = 1340;
    int ER_FPARSER_BAD_HEADER                      = 1341;
    int ER_FPARSER_EOF_IN_COMMENT                  = 1342;
    int ER_FPARSER_ERROR_IN_PARAMETER              = 1343;
    int ER_FPARSER_EOF_IN_UNKNOWN_PARAMETER        = 1344;
    int ER_VIEW_NO_EXPLAIN                         = 1345;
    int ER_FRM_UNKNOWN_TYPE                        = 1346;
    int ER_WRONG_OBJECT                            = 1347;
    int ER_NONUPDATEABLE_COLUMN                    = 1348;
    int ER_VIEW_SELECT_DERIVED                     = 1349;
    int ER_VIEW_SELECT_CLAUSE                      = 1350;
    int ER_VIEW_SELECT_VARIABLE                    = 1351;
    int ER_VIEW_SELECT_TMPTABLE                    = 1352;
    int ER_VIEW_WRONG_LIST                         = 1353;
    int ER_WARN_VIEW_MERGE                         = 1354;
    int ER_WARN_VIEW_WITHOUT_KEY                   = 1355;
    int ER_VIEW_INVALID                            = 1356;
    int ER_SP_NO_DROP_SP                           = 1357;
    int ER_SP_GOTO_IN_HNDLR                        = 1358;
    int ER_TRG_ALREADY_EXISTS                      = 1359;
    int ER_TRG_DOES_NOT_EXIST                      = 1360;
    int ER_TRG_ON_VIEW_OR_TEMP_TABLE               = 1361;
    int ER_TRG_CANT_CHANGE_ROW                     = 1362;
    int ER_TRG_NO_SUCH_ROW_IN_TRG                  = 1363;
    int ER_NO_DEFAULT_FOR_FIELD                    = 1364;
    int ER_DIVISION_BY_ZERO                        = 1365;
    int ER_TRUNCATED_WRONG_VALUE_FOR_FIELD         = 1366;
    int ER_ILLEGAL_VALUE_FOR_TYPE                  = 1367;
    int ER_VIEW_NONUPD_CHECK                       = 1368;
    int ER_VIEW_CHECK_FAILED                       = 1369;
    int ER_PROCACCESS_DENIED_ERROR                 = 1370;
    int ER_RELAY_LOG_FAIL                          = 1371;
    int ER_PASSWD_LENGTH                           = 1372;
    int ER_UNKNOWN_TARGET_BINLOG                   = 1373;
    int ER_IO_ERR_LOG_INDEX_READ                   = 1374;
    int ER_BINLOG_PURGE_PROHIBITED                 = 1375;
    int ER_FSEEK_FAIL                              = 1376;
    int ER_BINLOG_PURGE_FATAL_ERR                  = 1377;
    int ER_LOG_IN_USE                              = 1378;
    int ER_LOG_PURGE_UNKNOWN_ERR                   = 1379;
    int ER_RELAY_LOG_INIT                          = 1380;
    int ER_NO_BINARY_LOGGING                       = 1381;
    int ER_RESERVED_SYNTAX                         = 1382;
    int ER_WSAS_FAILED                             = 1383;
    int ER_DIFF_GROUPS_PROC                        = 1384;
    int ER_NO_GROUP_FOR_PROC                       = 1385;
    int ER_ORDER_WITH_PROC                         = 1386;
    int ER_LOGGING_PROHIBIT_CHANGING_OF            = 1387;
    int ER_NO_FILE_MAPPING                         = 1388;
    int ER_WRONG_MAGIC                             = 1389;
    int ER_PS_MANY_PARAM                           = 1390;
    int ER_KEY_PART_0                              = 1391;
    int ER_VIEW_CHECKSUM                           = 1392;
    int ER_VIEW_MULTIUPDATE                        = 1393;
    int ER_VIEW_NO_INSERT_FIELD_LIST               = 1394;
    int ER_VIEW_DELETE_MERGE_VIEW                  = 1395;
    int ER_CANNOT_USER                             = 1396;
    int ER_XAER_NOTA                               = 1397;
    int ER_XAER_INVAL                              = 1398;
    int ER_XAER_RMFAIL                             = 1399;
    int ER_XAER_OUTSIDE                            = 1400;
    int ER_XAER_RMERR                              = 1401;
    int ER_XA_RBROLLBACK                           = 1402;
    int ER_NONEXISTING_PROC_GRANT                  = 1403;
    int ER_PROC_AUTO_GRANT_FAIL                    = 1404;
    int ER_PROC_AUTO_REVOKE_FAIL                   = 1405;
    int ER_DATA_TOO_LONG                           = 1406;
    int ER_SP_BAD_SQLSTATE                         = 1407;
    int ER_STARTUP                                 = 1408;
    int ER_LOAD_FROM_FIXED_SIZE_ROWS_TO_VAR        = 1409;
    int ER_CANT_CREATE_USER_WITH_GRANT             = 1410;
    int ER_WRONG_VALUE_FOR_TYPE                    = 1411;
    int ER_TABLE_DEF_CHANGED                       = 1412;
    int ER_SP_DUP_HANDLER                          = 1413;
    int ER_SP_NOT_VAR_ARG                          = 1414;
    int ER_SP_NO_RETSET                            = 1415;
    int ER_CANT_CREATE_GEOMETRY_OBJECT             = 1416;
    int ER_FAILED_ROUTINE_BREAK_BINLOG             = 1417;
    int ER_BINLOG_UNSAFE_ROUTINE                   = 1418;
    int ER_BINLOG_CREATE_ROUTINE_NEED_SUPER        = 1419;
    int ER_EXEC_STMT_WITH_OPEN_CURSOR              = 1420;
    int ER_STMT_HAS_NO_OPEN_CURSOR                 = 1421;
    int ER_COMMIT_NOT_ALLOWED_IN_SF_OR_TRG         = 1422;
    int ER_NO_DEFAULT_FOR_VIEW_FIELD               = 1423;
    int ER_SP_NO_RECURSION                         = 1424;
    int ER_TOO_BIG_SCALE                           = 1425;
    int ER_TOO_BIG_PRECISION                       = 1426;
    int ER_M_BIGGER_THAN_D                         = 1427;
    int ER_WRONG_LOCK_OF_SYSTEM_TABLE              = 1428;
    int ER_CONNECT_TO_FOREIGN_DATA_SOURCE          = 1429;
    int ER_QUERY_ON_FOREIGN_DATA_SOURCE            = 1430;
    int ER_FOREIGN_DATA_SOURCE_DOESNT_EXIST        = 1431;
    int ER_FOREIGN_DATA_STRING_INVALID_CANT_CREATE = 1432;
    int ER_FOREIGN_DATA_STRING_INVALID             = 1433;
    int ER_CANT_CREATE_FEDERATED_TABLE             = 1434;
    int ER_TRG_IN_WRONG_SCHEMA                     = 1435;
    int ER_STACK_OVERRUN_NEED_MORE                 = 1436;
    int ER_TOO_LONG_BODY                           = 1437;
    int ER_WARN_CANT_DROP_DEFAULT_KEYCACHE         = 1438;
    int ER_TOO_BIG_DISPLAYWIDTH                    = 1439;
    int ER_XAER_DUPID                              = 1440;
    int ER_DATETIME_FUNCTION_OVERFLOW              = 1441;
    int ER_CANT_UPDATE_USED_TABLE_IN_SF_OR_TRG     = 1442;
    int ER_VIEW_PREVENT_UPDATE                     = 1443;
    int ER_PS_NO_RECURSION                         = 1444;
    int ER_SP_CANT_SET_AUTOCOMMIT                  = 1445;
    int ER_NO_VIEW_USER                            = 1446;
    int ER_VIEW_FRM_NO_USER                        = 1447;
    int ER_VIEW_OTHER_USER                         = 1448;
    int ER_NO_SUCH_USER                            = 1449;
    int ER_FORBID_SCHEMA_CHANGE                    = 1450;
    int ER_ROW_IS_REFERENCED_2                     = 1451;
    int ER_NO_REFERENCED_ROW_2                     = 1452;
    int ER_SP_BAD_VAR_SHADOW                       = 1453;
    int ER_PARTITION_REQUIRES_VALUES_ERROR         = 1454;
    int ER_PARTITION_WRONG_VALUES_ERROR            = 1455;
    int ER_PARTITION_MAXVALUE_ERROR                = 1456;
    int ER_PARTITION_SUBPARTITION_ERROR            = 1457;
    int ER_PARTITION_WRONG_NO_PART_ERROR           = 1458;
    int ER_PARTITION_WRONG_NO_SUBPART_ERROR        = 1459;
    int ER_CONST_EXPR_IN_PARTITION_FUNC_ERROR      = 1460;
    int ER_NO_CONST_EXPR_IN_RANGE_OR_LIST_ERROR    = 1461;
    int ER_FIELD_NOT_FOUND_PART_ERROR              = 1462;
    int ER_LIST_OF_FIELDS_ONLY_IN_HASH_ERROR       = 1463;
    int ER_INCONSISTENT_PARTITION_INFO_ERROR       = 1464;
    int ER_PARTITION_FUNC_NOT_ALLOWED_ERROR        = 1465;
    int ER_PARTITIONS_MUST_BE_DEFINED_ERROR        = 1466;
    int ER_RANGE_NOT_INCREASING_ERROR              = 1467;
    int ER_INCONSISTENT_TYPE_OF_FUNCTIONS_ERROR    = 1468;
    int ER_MULTIPLE_DEF_CONST_IN_LIST_PART_ERROR   = 1469;
    int ER_PARTITION_ENTRY_ERROR                   = 1470;
    int ER_MIX_HANDLER_ERROR                       = 1471;
    int ER_PARTITION_NOT_DEFINED_ERROR             = 1472;
    int ER_TOO_MANY_PARTITIONS_ERROR               = 1473;
    int ER_SUBPARTITION_ERROR                      = 1474;
    int ER_CANT_CREATE_HANDLER_FILE                = 1475;
    int ER_BLOB_FIELD_IN_PART_FUNC_ERROR           = 1476;
    int ER_CHAR_SET_IN_PART_FIELD_ERROR            = 1477;
    int ER_UNIQUE_KEY_NEED_ALL_FIELDS_IN_PF        = 1478;
    int ER_NO_PARTS_ERROR                          = 1479;
    int ER_PARTITION_MGMT_ON_NONPARTITIONED        = 1480;
    int ER_DROP_PARTITION_NON_EXISTENT             = 1481;
    int ER_DROP_LAST_PARTITION                     = 1482;
    int ER_COALESCE_ONLY_ON_HASH_PARTITION         = 1483;
    int ER_ONLY_ON_RANGE_LIST_PARTITION            = 1484;
    int ER_ADD_PARTITION_SUBPART_ERROR             = 1485;
    int ER_ADD_PARTITION_NO_NEW_PARTITION          = 1486;
    int ER_COALESCE_PARTITION_NO_PARTITION         = 1487;
    int ER_REORG_PARTITION_NOT_EXIST               = 1488;
    int ER_SAME_NAME_PARTITION                     = 1489;
    int ER_CONSECUTIVE_REORG_PARTITIONS            = 1490;
    int ER_REORG_OUTSIDE_RANGE                     = 1491;
    int ER_DROP_PARTITION_FAILURE                  = 1492;
    int ER_DROP_PARTITION_WHEN_FK_DEFINED          = 1493;
    int ER_PLUGIN_IS_NOT_LOADED                    = 1494;
    int ER_MULTI_QUERY_TIMEOUT                     = 1495;
    int ER_MULTI_EXEC_ERROR                        = 1496;

}
