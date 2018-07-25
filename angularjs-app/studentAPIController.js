angular.module('studentAPIModule',[])
.controller('studentAPIController',['$scope','$timeout','dispStudentService','getStudentAPIService',function($scope,$timeout,dispStudentService,getStudentAPIService){
    $scope.students=[];
    $scope.savehide=true;
    $scope.addhide=false;
    $scope.formdata={
        rno:'',
        name:'',
        age:'',
        email:'',
        date:'',
        gender:''
    }
    $scope.star={
        rno:'',
        name:'',
        age:'',
        email:'',
        date:'',
        gender:''
    }
    $scope.loadingimg=false;
    //load initial data
    getStudentAPIService.getStudents()
    .then(function(response) {
        $scope.loadingimg=true;
        dispStudentService.load(response);
    });
    $scope.students=dispStudentService.getData();
    
    //add a new data
    $scope.add=function(){
        
        var d =new Date($scope.formdata.date);
        var datestring =("0"+(d.getMonth()+1)).slice(-2) +"/" +  ("0" + d.getDate()).slice(-2) + "/" +   + d.getFullYear();
        $scope.formdata.date = datestring;

        var tocall=validate();
        dispStudentService.addStudent(tocall,$scope.formdata);    
        clearFormAfterEdit();            
    }
    function validate(){
    var incomplete=0;

    if($scope.formdata.rno==null || $scope.formdata.rno==""){
        // $("#rnostar").css("color", "red");
        $scope.star.rno='*';
        incomplete=1;
    }
    else{
        $scope.star.rno='';
        incomplete=0;
    }
    if($scope.formdata.age==null || $scope.formdata.age==""){
        $scope.star.age='*';
        incomplete=1;
    }
    else{
        $scope.star.age='';
        incomplete=0;
    }
    if($scope.formdata.name==null || $scope.formdata.name==""){
        $scope.star.name='*';
        incomplete=1;
    }
    else{
        $scope.star.name='';
        incomplete=0;
    }
    if($scope.formdata.date==null || $scope.formdata.date==""){
        // $scope.formdata.date="2018-06-07";
    }
    else{
        $scope.star.date='';
        incomplete=0;
    }
    if($scope.formdata.email==null || $scope.formdata.email==""){
        console.log($scope.formdata.email);
        $scope.star.email='*';
        incomplete=1;
    }
    else{
        $scope.star.email='';
        incomplete=0;
    }
    if(incomplete==1){
        return 1;
    }
    return 0;
    }

    //delete a data

    $scope.delete=function(rno){
        var confirmation = confirm("Do you want to delete this row?");
        if (confirmation == true) {
            getStudentAPIService.deleteStudent(rno)
            .then(function() {
            alert("DELETED");
            getStudentAPIService.getStudents()
            .then(function(response) {
            
            console.log(response);
            dispStudentService.load(response);
            });
        });
        }

    }
    
    
    //edit data
    $scope.edit=function(rollno_to_edit){
        for(var i=0;i<$scope.students.length;i++){
            if($scope.students[i].rollno==rollno_to_edit)
            {
                $scope.students[i].color='green';
            }
            else{
                if($scope.students[i].gender=='male'){
                    $scope.students[i].color='blue';
                }
                else{
                    $scope.students[i].color='pink';
                }
            }
        }
        getStudentAPIService.editStudent(rollno_to_edit)
        .then(function(response) {
            disp_form(response);
        });
    }
function disp_form(result){
    var g;
    $scope.formdata.rno=result.data.rollNo;
    $scope.formdata.age=result.data.age;
    $scope.formdata.name=result.data.name;
    $scope.formdata.email=result.data.email;
    $scope.formdata.date=new Date(result.data.date);   
    if(result.data.isMale==true)
            g='male';
        else
            g='female';         
    $scope.formdata.gender=g;
    $scope.savehide=false;
    $scope.addhide=true;
}
$scope.saveUpdate=function(){
    var gender;
    if($scope.formdata.gender=="male"){
        gender=true;
    }
    else{
        gender=false;
    }    

    var d =new Date($scope.formdata.date);
    var datestring =("0"+(d.getMonth()+1)).slice(-2) +"/" +  ("0" + d.getDate()).slice(-2) + "/" +   + d.getFullYear();
    $scope.formdata.date = datestring;
    var dataToedit;
    dataToedit ={ "rollNo":$scope.formdata.rno,"name":$scope.formdata.name,"age":$scope.formdata.age,"email":$scope.formdata.email,"date":$scope.formdata.date,"isMale":gender};
    getStudentAPIService.updateStudent(dataToedit,$scope.formdata.rno)
    .then(function() {
            alert("DATA UPDATED");
            getStudentAPIService.getStudents()
            .then(function(response) {
                dispStudentService.load(response);
                clearFormAfterEdit();
            });
    });
}
function clearFormAfterEdit(){

    $scope.formdata.rno='';
    $scope.formdata.age='';
    $scope.formdata.name='';
    $scope.formdata.email='';
    $scope.formdata.date='';            
    $scope.formdata.gender='';
    $scope.savehide=true;
    $scope.addhide=false;
}
           
}]);