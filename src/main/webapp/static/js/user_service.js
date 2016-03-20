myApp.service('ContactService', ['$http', '$q', function ($http, $q) {

    this.fetchAllContacts = function () {
            return $http.get('/contact/')
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while fetching contacts');
                        return $q.reject(errResponse);
                    }
                );
        },

        this.createContact = function (contact) {
            return $http.post('/contact/', contact)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while creating contact');
                        return $q.reject(errResponse);
                    }
                );
        },

        this.updateContact = function (contact, id) {
            return $http.put('/contact/' + id, contact)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while updating contact');
                        return $q.reject(errResponse);
                    }
                );
        },

        this.deleteContact = function (id) {
            return $http.delete('/contact/' + id)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error while deleting contact');
                        return $q.reject(errResponse);
                    }
                );
        }


}]);