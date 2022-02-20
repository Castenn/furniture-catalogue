import {createRouter, createWebHistory} from "vue-router";
import Home from "./components/Home.vue";
import NotFound from "./components/NotFound.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/:pathMatch(.*)*",
      name: "notFound",
      component: NotFound
    },
  ],
});

export default router;
