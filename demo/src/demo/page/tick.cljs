(ns demo.page.tick
  (:require
   [reagent.core :as r]
   [tick.core :as t]
   [tick.editor :refer [instant-editor]]
   ))

(def day1 (t/new-duration 1 :days))

(defn move-back [dt]
  (t/<< dt day1))

(defn move-forward [dt]
  (t/>> dt day1))

(defn dt-scroller [dt-a]
  [:div.bg-blue-300
   [:button {:on-click #(swap! dt-a move-back)} "<"]
   [:button {:on-click #(swap! dt-a move-forward)} ">"]
   [:span (str @dt-a)]
   [instant-editor {:instant-a dt-a}]
   ])

(defn page [{:keys [_route-params _query-params _handler] :as _route}]
  (let [dt-a (r/atom (-> (t/instant) (t/truncate :seconds)))]
    (fn [{:keys [_route-params _query-params _handler] :as _route}]
      [:div
       [dt-scroller dt-a]
       
    
    ])))
