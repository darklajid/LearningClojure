(defn primes "Generates an (infinite, lazy) sequence of primes"
  []
  (letfn [(reinsert [table x prime]
            (let [key (+ prime x)]
              (update-in table [key] conj prime)))
          (primes-step [table d]
              (if-let [factors (get table d)]
                (recur (reduce #(reinsert %1 d %2)
                               (dissoc table d)
                               factors)
                       (inc d))
                (lazy-seq
                 (cons d (primes-step (assoc table
                                        (* d d) (list d))
                                      (inc d))))))]
    (primes-step {} 2)))
