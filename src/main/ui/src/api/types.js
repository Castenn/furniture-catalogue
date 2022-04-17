import axios from "axios";
import TypeList from "../models/TypeList";
import Type from "../models/Type";

const TYPES_PATH = 'http://localhost:8080/api/type/'

class Types {
    getAllTypes() {
        return axios.get(`${TYPES_PATH}all`)
            .then(response => new TypeList(response.data.map(type => new Type(type))))
    }

    getTypeById(id) {
        return axios.get(`${TYPES_PATH}${id}`)
            .then(response => new Type(response.data))
    }
}

let types = null

export const typesApi = {
    getInstance() {
        if (types == null) {
            types = new Types();
        }
        return types;
    }
}
