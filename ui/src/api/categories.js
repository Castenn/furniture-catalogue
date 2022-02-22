const CATEGORIES_LIST_PATH = 'http://localhost:8080/category/all'

class Categories {

    async getAllCategories() {
        const response = await fetch(CATEGORIES_LIST_PATH)
        return response.json()
    }
}

let categories = null

export const categoriesApi = {
    getInstance() {
        if (categories == null) {
            categories = new Categories()
        }
        return categories
    }
}
