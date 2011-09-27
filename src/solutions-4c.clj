;; Solutions for https://4clojure.com

(defn s66  "Greatest Common Divisor, https://4clojure.com/problem/120"
  [a b]
  (loop [a a b b]
    (if (= b 0)
      a
      (recur b (mod a b)))))

(defn s81 "Set intersection, https://4clojure.com/problem/81"
  [a b]
  (set (filter #(contains? b %) a)))

(defn s120 "Sum of square digits, https://4clojure.com/problem/120"
  [aseq]
  (letfn [(sos [d] (->> d str (map #(* (Integer. (str %)) (Integer. (str %)))) (reduce +)))]
    (reduce #(if (< %2 (sos %2)) (inc %1) %1) 0 aseq)))