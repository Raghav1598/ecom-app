import axios from 'axios'

class LoginService{

    loginHandler(email){
        return axios.get(`http://localhost:8080/signup/${email}`)
    }
}

export default new LoginService();