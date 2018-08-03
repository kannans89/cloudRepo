var mysql = require('mysql');

    var r=100;
  var rn=108;
  var location="bandra";
  var name="devalll";
var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "swabhav"
});
con.connect(function (err) {
  
  var studentObj;
  if (err) throw err;
  console.log("Connected!");
  con.query("select * from student", function (err, result) {
    if (err)
      throw err;
    studentObj=JSON.parse(JSON.stringify(result));
    console.log(studentObj);
  });
  con.query("insert into student(roll_no,name,location) values ?",[r], function (err, result) {
    
    if (err)
      throw err;
    
  });
  con.query("delete from student where roll_no="+rn, function (err, result) {
    
    if (err)
      throw err;
    
  });

  
  
});