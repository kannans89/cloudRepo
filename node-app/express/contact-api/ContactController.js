var ContactService = require('./ContactService');
var svc = new ContactService();
function ContactController(app) {
    app.get('/api/v1/contacts', (req, res) => {
        svc.getContacts((contactObj) => {
            res.json(contactObj);
        })
    })
        .get('/',(req,res)=>{res.sendfile('./public/6contactApi.html' )})
        .delete('/api/v1/contacts/:phone*?', (req, res) => { svc.removeContact(req.params.phone); })
        .get('/api/v1/contacts/:phone*?', (req, res) => {
            svc.getContact(req.params.phone, (contactObj) => {
                res.json(contactObj);
            })
        })
        .put('/api/v1/contacts/:phone*?', (req, res) => {
            req.on('data', function (updateContact) {
                svc.updateContact(req.params.phone, JSON.parse(updateContact.toString()));
            });

        })
        .post('/api/v1/contacts', (req, res) => {
            req.on('data', function (newContact) {
                svc.addContact(JSON.parse(newContact.toString()));
            });
        })
        .post('/api/authenticate', (req, res) => {
            req.on('data', function (details) {
                svc.authenticate(JSON.parse(details.toString()),(authenticationRes)=>{
                    res.send(authenticationRes);
                });
            });
            
        })

        .listen(5555, () => console.log('app listening on port 5555'));
}
module.exports = ContactController;