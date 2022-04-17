import {Collection} from "vue-mc";
import Type from "./Type";

export default class TypeList extends Collection {
    options () {
        return {
            model: Type
        }
    }
}
