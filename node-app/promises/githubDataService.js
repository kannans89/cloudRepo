var fs = require('fs');
var json = JSON.parse(fs.readFileSync('githubData.json', 'utf8'));
var dataService=function(){
    var obj={};

    obj.display=function(commits){
        console.log("there are "+commits.length+" commits");
        for(var i=0;i<commits.length;i++)
        console.log("id: "+commits[i].id+" | date: "+commits[i].date+" | reason: "+commits[i].reason);
        
    }

    obj.getUserById=function(id){

        var promise= new Promise(function(resolve) {   
            var userName=json[0].name;  
            resolve(userName);
        });
        return promise;

    }
    obj.getReposByUser=function(user){

        var promise= new Promise(function(resolve) {  
            console.log(user);
            var repos=json[0].repositories;  
            resolve(repos);
        });
        return promise;

    }
    obj.commitsForRepos=function(repository){

        var commits;
        var promise= new Promise(function(resolve) {   
            for(var i=0;i<json[0].repositories.length;i++){
                if(repository.id==json[0].repositories[i].id){
                    commits=json[0].repositories[i].commits;
                }
            }
            resolve(commits);
        });
        return promise;

    }

    return obj;
}
module.exports=dataService;