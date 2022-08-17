#!/bin/bash
export JAVA_HOME=$JAVA_HOME_1_6

rm -rf output
mkdir output

mvn clean package -Dmaven.test.skip=true

cd target
unzip -o heisenberg-server-1.0.3.2.zip
cd heisenberg-server-1.0.3.2
tar czf heisenberg-server.tgz *
cd ../../
mysqldump -h 182.61.50.237 -u baiduyun_console -pbaiduyun_@2022 -d gogs> G:\baidu-int.com\heisenberg-server.sql
cp target/heisenberg-server-1.0.3.2/heisenberg-server.tgz output/
