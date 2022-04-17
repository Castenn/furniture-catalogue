import {createRouter, createWebHistory} from "vue-router";
import Main from "./views/Main.vue";
import NotFound from "./views/NotFound.vue";
import Login from "./views/Login.vue";
import About from "./views/About.vue";
import ShowProduct from "./views/ShowProduct.vue";
import AddProduct from "./views/AddProduct.vue";
import EditProduct from "./views/EditProduct.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "main",
      component: Main
    },
    {
      path: "/product/add",
      name: "addProduct",
      component: AddProduct
    },
    {
      path: "/product/show/:productId",
      name: "showProduct",
      component: ShowProduct
    },
    {
      path: "/product/edit/:productId",
      name: "editProduct",
      component: EditProduct
    },
    {
      path: "/login",
      name: "login",
      component: Login
    },
    {
      path: "/about",
      name: "about",
      component: About
    },
    {
      path: "/:pathMatch(.*)*",
      name: "notFound",
      component: NotFound
    },
  ],
});

export default router;
