const TYPES_LIST_PATH = 'http://localhost:8080/type/all'

class Types {

    async getAllTypes() {
        const response = await fetch(TYPES_LIST_PATH);
        return response.json();
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
