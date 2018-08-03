const csv=require('csvtojson')
var empName=[];
var employee=[];
csv({
    noheader:true,
    output: "csv"
})
.fromFile('./dataFile.txt')
.then((row)=>{
    var emp=sort(row);
    countEmployees(emp);
});
function countEmployees(emp){
    var mgrCount=0;
    var clerkCount=0;
    var analystCount=0;
    var salesmanCount=0;
    for(var i=0;i<emp.length;i++){
        if(emp[i][2]=="'MANAGER'")
            mgrCount++;
        else if(emp[i][2]=="'CLERK'")
            clerkCount++;
        else if(emp[i][2]=="'ANALYST'")
            analystCount++;
        else if(emp[i][2]=="'SALESMAN'")
            salesmanCount++;



    }
    console.log("No. of manager: "+mgrCount);
    console.log("No. of clerks: "+clerkCount);
    console.log("No. of analysts: "+analystCount);
    console.log("No. of salesman: "+salesmanCount);

}
function sort(row){
    var i;
    for(i=0;i<row.length;i++){
        empName[i]=row[i][1];
        employee[i]=row[i];
    }
    var len = empName.length,j, stop;
    for (i=0; i < len; i++){
        for (j=0, stop=len-i; j < stop; j++){
            if (empName[j] > empName[j+1]){
                var temp = empName[j];
                empName[j] = empName[j+1];
                empName[j+1] = temp;
                temp = employee[j];
                employee[j] = employee[j+1];
                employee[j+1] = temp;
            }
        }
    }
    for(i=0;i<row.length;i++){
        console.log(empName[i]);
    }
    return employee;
}
