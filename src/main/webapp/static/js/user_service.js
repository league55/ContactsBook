myApp.factory('ContactService', ['$http', '$q', function ($http, $q) {

    return {

        fetchAllContacts: function () {
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

        createContact: function (contact) {
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

        updateContact: function (contact, tel) {
            return $http.put('/contact/' + tel, contact)
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

        deleteUser: function (tel) {
            return $http.delete('/contact/' + tel)
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

    };

}]);