import {createRouter, createWebHistory} from "vue-router";
import Main from "./components/Main.vue";
import NotFound from "./components/NotFound.vue";
import Signin from "./components/Signin.vue";
import About from "./components/About.vue";
import ShowProduct from "./components/ShowProduct.vue";
import AddProduct from "./components/AddProduct.vue";
import EditProduct from "./components/EditProduct.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "main",
      component: Main
    },
    {
      path: "/product/show",
      name: "showProduct",
      component: ShowProduct
    },
    {
      path: "/product/add",
      name: "addProduct",
      component: AddProduct
    },
    {
      path: "/product/edit",
      name: "editProduct",
      component: EditProduct
    },
    {
      path: "/signin",
      name: "signin",
      component: Signin
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
