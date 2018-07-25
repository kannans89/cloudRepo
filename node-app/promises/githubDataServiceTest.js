var Dataservice=require('./githubDataService');
let service=Dataservice();
service.getUserById(1001)
.then(user=>service.getReposByUser(user))
.then(repos=>service.commitsForRepos(repos[1]))
.then(commits=>service.display(commits));