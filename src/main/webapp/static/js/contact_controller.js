var myApp = angular.module('myApp');

myApp.controller('ContactController', ['$scope', 'Contact', function ($scope, Contact) {
    var self = this;
    self.contact = new Contact();
    self.contacts = [];


    self.fetchAllContacts = function () {
        self.contacts = Contact.query();
        console.log('fetched ' + self.contacts.length + ' cont');
        for (var i = 0; i < self.contacts.length; i++) {
            console.log(self.contacts[i].id);
        }
    };

    self.createContact = function () {
        self.contact.$save(function () {
            self.fetchAllContacts();
        })
    };

    self.updateContact = function () {
        self.contact.$update(function () {
            self.fetchAllContacts();
        })
    };

    self.deleteContact = function (id) {
        var contact = Contact.get({id: id}, function () {
            contact.$delete(function () {
                console.log('deleting contact with id' + id);
                self.fetchAllContacts();
            })
        })
    };


    self.fetchAllContacts();


    self.submit = function () {
        console.log(self.contact.id);
        if (self.contact.id == null) {
            console.log('adding contact with id ' + self.contact.id);
            self.createContact();
        } else {
            console.log('updating contact with id ' + self.contact.id);
            self.updateContact();
        }
        self.reset();
    };

    self.edit = function (id) {
        console.log('contact ' + id + ' is to be edited');
        for (var i = 0; i < self.contacts.length; i++) {
            if (self.contacts[i].id === id) {
                self.contact = angular.copy(self.contacts[i]);
                break;
            }
        }
    };

    self.remove = function (id) {
        console.log('id ' + id + 'is to be deleted');
        if (self.contact.id === id) {
            self.reset();
        }
        self.deleteContact(id);
    };

    self.reset = function () {
        self.contact = new Contact();
        $scope.myForm.$setPristine();
    };

}]);