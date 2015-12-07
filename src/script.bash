#!/bin/bash
###############################################################
# 
# Fichier de configuration d'Oracle
#
###############################################################
# A lancer une fois connecté sur la machine Oracle  
# -------------------------------------------------------------

echo "Configuration d'Oracle ... "

export PATH=$PATH:/home/oracle/app/oracle/product/11.2.0/dbhome_1/bin
export ORACLE_HOME=/home/oracle/app/oracle/product/11.2.0/dbhome_1
export ORACLE_SID=oracle
export ORACLE_HOME_LISTNER=$ORACLE_HOME
export CLASSPATH=$ORACLE_HOME/jdbc/lib/ojdbc5.jar:.:$CLASSPATH

echo $CLASSPATH

echo "Configuration ok ! "