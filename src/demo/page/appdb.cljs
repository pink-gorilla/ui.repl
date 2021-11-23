



(defn appdb-page [{:keys [route-params query-params handler] :as route}]

  [:div
   [:button.bg-blue-300.m-2 {:on-click #(rf/dispatch [:bidi/goto :goldly/about])}
    "goto main"]

   "format"
   (format "hello %s !" "mr X.")

   "current route: "
   (current-route)

   "app db: "
   [:p.bg-blue-300
    (pr-str (app-db))]])

(add-page appdb-page :demo-appdb)
