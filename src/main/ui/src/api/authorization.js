import axios from "axios";

const AUTHORIZATION_API = 'http://localhost:8080/api/authorization';

class Authorization {
    getAuthorization(login, password) {
        return axios.post(AUTHORIZATION_API + '/login', {
            login: login,
            password: password
        });
    }
}

let authorization = null

export const authorizationApi = {
    getInstance() {
        if (authorization == null) {
            authorization = new Authorization();
        }
        return authorization;
    }
}
