angular.module('studentAPIModule')
        .factory('getStudentAPIService',['$http',function($http){
            var api_url="http://gsmktg.azurewebsites.net:80/api/v1/techlabs/test/students/";
            var obj={};                 

            obj.getStudents=function(no){
                return $http.get(api_url)                           
            }
            obj.setStudent=function(dataToAdd){
                return $http.post(api_url, dataToAdd)
            }
            obj.deleteStudent=function(rno){
                return $http.delete(api_url+ rno)
            }
            obj.editStudent=function(rno){
                return $http.get(api_url+rno)                           
            }
            obj.updateStudent=function(data,rno){
                return $http.put(api_url+rno,data)                           
            }
            return obj;
        }]) 
        .factory('dispStudentService',['$timeout','getStudentAPIService',function($timeout,getStudentAPIService){
            var obj={};                 
            var studentsList=[];
            
            obj.getData=function(){
                return studentsList;
            }

            obj.load=function(response){
                
                $timeout(function(){
                    display(response);
                },1000);
            }

            function display(result){  
            var cnt=0;
            var tempStudent={};
            var length=result.data.length;
            
            for(var i=0;i<length;i++){
                var g;
                
                if(result.data[i].isMale==true){
                    g="male";
                    tempStudent.color='blue';
                }
                else{
                    g="female";
                    tempStudent.color='pink';
                }
                tempStudent.rollno=result.data[i].rollNo;
                tempStudent.name=result.data[i].name;
                tempStudent.age=result.data[i].age;
                tempStudent.email=result.data[i].email;
                tempStudent.date=result.data[i].date;
                tempStudent.gender=g;
                
                
                studentsList[cnt++]=tempStudent;
                tempStudent={};
            }                      
            }
            
            obj.addStudent=function(tocall,formdata){
                
                if(tocall==0){
                    displayData(formdata);
                } 
                else{
                    alert("form incomplete");
                }
            }


            function displayData(formdata){
            var gender;
            
            if(formdata.gender=="male"){
                gender=true;
            }
            else{
                gender=false;
            }            

            var dataToAdd;
            dataToAdd ={ "rollNo":formdata.rno,"name":formdata.name,"age":formdata.age,"email":formdata.email,"date":formdata.date,"isMale":gender};
            getStudentAPIService.setStudent(dataToAdd)
                .then(function() {
                    alert("ADDED");
                    getStudentAPIService.getStudents()
                    .then(function(response) {
                        
                        obj.load(response);
                    });
                });            
            }

            return obj;
        }]) 