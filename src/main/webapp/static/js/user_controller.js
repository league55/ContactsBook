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
                self.fetchAllContacts,
                function (errResponse) {
                    console.error('Error while creating User.');
                }
            );
    };

    self.updateContact = function (contact, id) {
        ContactService.updateContact(contact, id)
            .then(
                self.fetchAllContacts,
                function (errResponse) {
                    console.error('Error while updating User.');
                }
            );
    };

    self.deleteContact = function (tel) {
        ContactService.deleteContact(tel)
            .then(
                self.fetchAllContacts,
                function (errResponse) {
                    console.error('Error while deleting User.');
                }
            );
    };

    self.fetchAllContacts();

    self.submit = function () {
        console.log(self.contact.id + "id ");
        if (self.contact.id === null) {
            console.log('Saving New Contact', self.contact);
            self.createContact(self.contact);
        } else {
            self.updateContact(self.contact, self.contact.id);
            console.log('Contact updated with id ', self.contact.id);
        }
        self.reset();
    };

    self.edit = function (id) {
        console.log('id to be edited', id);
        for (var i = 0; i < self.contacts.length; i++) {
            if (self.contacts[i].id === id) {
                self.contact = angular.copy(self.contacts[i]);
                break;
            }
        }
    };

    self.remove = function (id) {
        console.log('id to be deleted', id);
        if (self.contact.id === id) {//clean form if the contact to be deleted is shown there.
            self.reset();
        }
        self.deleteContact(id);
    };


    self.reset = function () {
        self.contact = {id: null, firstName: '', lastName: '', tel: ''};
        $scope.myForm.$setPristine(); //reset Form
    };

}]);