var BankService = require('./BankService');
var svc = new BankService();
function BankController(app) {

    app.post('/api/bank/register', (req, res) => {
        console.log("REGISTER");
        req.on('data', function (newMaster) {
            svc.addMaster(JSON.parse(newMaster.toString()));
        });
    })
        .post('/api/bank/login', (req, res) => {
            console.log("LOGIN");
            req.on('data', function (user) {
                svc.authenticateUser(JSON.parse(user.toString()), (authenticationRes) => {
                    res.send(authenticationRes);
                });
            });
        })
        .post('/api/bank/action', (req, res) => {
            console.log("ACTION");
            req.on('data', function (action) {
                
                svc.doAction(JSON.parse(action.toString()));
            });
        })
        .get('/api/bank/passbook', (req, res) => {
            svc.getPassbook((passbook) => {
                res.json(passbook);
            })
        })
        .listen(5556, () => console.log('app listening on port 5556'));
}
module.exports = BankController;




