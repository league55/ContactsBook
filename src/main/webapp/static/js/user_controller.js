var myApp = angular.module('myApp');

myApp.controller('ContactController', ['$scope', 'ContactService', function ($scope, ContactService) {
    var self = this;
    self.contact = {id: null, firstName: '', lastName: '', tel: ''};
    self.contacts = [];

    self.fetchAllContacts = function () {
        ContactService.fetchAllContacts()
            .then(
                function (d) {
                    self.contacts = d;
                },
                function (errResponse) {
                    console.error('Error while fetching Currencies');
                }
            );
    };

    self.createContact = function (contact) {
        ContactService.createContact(contact)
            .then(
                self.fetchAllUsers,
                function (errResponse) {
                    console.error('Error while creating User.');
                }
            );
    };

    self.updateContact = function (contact, tel) {
        ContactService.updateContact(contact, tel)
            .then(
                self.fetchAllUsers,
                function (errResponse) {
                    console.error('Error while updating User.');
                }
            );
    };

    self.deleteContact = function (id) {
        ContactService.deleteContact(id)
            .then(
                self.fetchAllUsers,
                function (errResponse) {
                    console.error('Error while deleting User.');
                }
            );
    };

    self.fetchAllContacts();

    self.submit = function () {
        if (self.contact.tel === null) {
            console.log('Saving New Contact', self.contact);
            self.createContact(self.contact);
        } else {
            self.updateContact(self.contact, self.contact.tel);
            console.log('Contact updated with id ', self.contact.tel);
        }
        self.reset();
    };

    self.edit = function (tel) {
        console.log('id to be edited', tel);
        for (var i = 0; i < self.contacts.length; i++) {
            if (self.contacts[i].tel === tel) {
                self.contact = angular.copy(self.contacts[i]);
                break;
            }
        }
    };

    self.remove = function (tel) {
        console.log('id to be deleted', tel);
        if (self.contact.id === id) {//clean form if the contact to be deleted is shown there.
            self.reset();
        }
        self.deleteUser(tel);
    };


    self.reset = function () {
        self.contact = {id: null, firstName: '', lastName: '', tel: ''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);