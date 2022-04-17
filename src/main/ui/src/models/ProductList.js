import {Collection} from "vue-mc";
import Product from "./Product";

export default class ProductList extends Collection {
    options () {
        return {
            model: Product
        }
    }
}
