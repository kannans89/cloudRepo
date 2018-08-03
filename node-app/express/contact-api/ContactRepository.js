var mysql = require('mysql');

function ContactRepository() {

    this.getContacts = function (callback) {
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
            con.query("select * from contacts", function (err, result) {
                if (err)
                    throw err;
                studentObj = JSON.parse(JSON.stringify(result));
                callback(studentObj);
            });
        });


    }
    this.addContact = function (newContact) {
        var data = [[newContact.name, newContact.email, newContact.phone]];
        var con = mysql.createConnection({
            host: "localhost",
            user: "root",
            password: "root",
            database: "swabhav"
        });
        con.connect(function (err) {

            if (err) throw err;
            console.log("insert Connected!");
            con.query("insert into contacts values ?", [data], function (err, result) {
                if (err)
                    throw err;

            });
        });
    }
    this.removeContact = function (phone) {

        var con = mysql.createConnection({
            host: "localhost",
            user: "root",
            password: "root",
            database: "swabhav"
        });
        con.connect(function (err) {

            if (err) throw err;
            console.log("delete Connected!");
            con.query("delete from contacts where phone=" + phone, function (err, result) {
                if (err)
                    throw err;

            });
        });
    }

    this.getContact = function (phone, callback) {
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
            con.query("select * from contacts where phone=" + phone, function (err, result) {
                if (err)
                    throw err;
                studentObj = JSON.parse(JSON.stringify(result));

                callback(studentObj);
            });
        });
    }

    this.updateContact = function (phone, updateContact) {

        var con = mysql.createConnection({
            host: "localhost",
            user: "root",
            password: "root",
            database: "swabhav"
        });
        con.connect(function (err) {

            if (err) throw err;
            console.log("update Connected!");
            con.query("update contacts set name= ?,email= ?,phone=? where phone=?", [updateContact.name, updateContact.email, updateContact.phone, phone], function (err, result) {
                if (err)
                    throw err;

            });
        });
    }

    this.authenticate = function (details,callback) {
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
            con.query("select * from authenticate where username= ? and password= ?", [details.username, details.password], function (err, result) {
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
}
module.exports = ContactRepository;