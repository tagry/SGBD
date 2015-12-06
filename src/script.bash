echo "Script de creation de la base"

ssh oracle
echo "definition de CLASSPATH"
export CLASSPATH=$ORACLE_HOME/jdbc/lib/ojdbc5.jar:.:$CLASSPATH

sqlplus wsoulaimana wsoulaimana