var mysql = require('mysql');
function BankRepository() {
    var id=1;
    var date='today';
    var type='D';
    this.addMaster = function (newMaster) {
        var data_master = [[newMaster.name, newMaster.balance, newMaster.password]];
        var data_transactions = [[id, date, newMaster.balance,type,newMaster.name]];
        id++;
        var con = mysql.createConnection({
            host: "localhost",
            user: "root",
            password: "root",
            database: "swabhav"
        });
        con.connect(function (err) {

            if (err) throw err;
            console.log("insert Connected!");
            con.query("insert into bank_master values ?", [data_master], function (err, result) {
                if (err)
                    throw err;

            });
            
            con.query("insert into bank_transactions values ?", [data_transactions], function (err, result) {
                if (err)
                    throw err;
                
            });
        });
    }
    this.authenticateUser=function(user,callback){
        var authenticationResult;
        var con = mysql.createConnection({
            host: "localhost",
            user: "root",
            password: "root",
            database: "swabhav"
        });
        con.connect(function (err) {
            
            if (err) throw err;
            console.log("select Connected!");
            con.query("select * from bank_master where name= ? and password= ?", [user.username, user.password], function (err, result) {
                if (err)
                    throw err;
                authenticationResult = JSON.parse(JSON.stringify(result));
                
                if(authenticationResult.length!=0){
                    callback(true);
                }
                else
                    callback(false);

            });
        });
    }
    this.doAction = function (action) {
        
        var newAction=[[action.id,date,action.amount,action.type,action.name]];
        console.log(id);
        var balance;
        var con = mysql.createConnection({
            host: "localhost",
            user: "root",
            password: "root",
            database: "swabhav"
        });
        con.connect(function (err) {
            
            if (err){ console.log("===ERROR in connect==="); throw err};
            console.log("select Connected!");
            
            con.query("select balance from bank_master where name=?",[action.name], function (err, result) {
                if (err){ console.log("===ERROR in getting balance==="); throw err};
                
                result=JSON.parse(JSON.stringify(result));
                if(action.type=='D'){
                    balance=parseInt(result[0].balance)+parseInt(action.amount);
                }
                else{
                    balance=parseInt(result[0].balance)-parseInt(action.amount);
                }
                console.log(balance);
                update(balance,con,action);
                insert(newAction,con);
            });
            
            
        });
    
    }
    function insert(newAction,con){
        // newAction.id++;
        console.log("insert Connected!");
            con.query("insert into bank_transactions values ?", [newAction], function (err, result) {
                if (err){ console.log("===ERROR in inserting transaction in bank_transactions==="); throw err};
                
            });
    }
    function update(balance,con,action){
        console.log("update Connected!");
            
            con.query("update bank_master set balance=? where name=?", [balance,action.name], function (err, result) {
                if (err){ console.log("===ERROR in updateing balance of bank_master==="); throw err};

            });
    }

    this.getPassbook = function (callback) {
        var studentObj;
        var con = mysql.createConnection({
            host: "localhost",
            user: "root",
            password: "root",
            database: "swabhav"
        });
        con.connect(function (err) {

            if (err) throw err;
            console.log("select Connected!");
            con.query("select * from bank_transactions", function (err, result) {
                if (err)
                    throw err;
                passbook = JSON.parse(JSON.stringify(result));
                callback(passbook);
            });
        });
    }

}
module.exports = BankRepository;