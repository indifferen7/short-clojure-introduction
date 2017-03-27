;;; first steps

; prints a string to stdout
(println "Hello world!")

; try to evaluate this if you dare!
(1 2 3)

; some calculations
; prefix vs infix
(+ 1 2)
(+ 1 2 3)

; nested expressions
(+ 1 2 (- 4 1))

; Java interop!
(type "foo")
(type 1)
(count "foo")
(.length "foo")

; create a named var
(def foo "moo")

; an anonymous function, cmp with javascript
(def anonymous
  (fn [n] (* n n)))

; shorthand anonymous function, syntactic sugar
(def anonymous #(* %1 %1))

; create a named function, cmp with javascript
(defn square
  "Squares the provided number"
  [n]
  (* n n))

; exemplify documentation
(doc square)

;;; map, reduce and filter - the functional work horses
;;; task: take all even numbers in a sequence, square them
;;; and summarize the squared values.

; a vector is the most commonly used sequence in Clojure
(def numbers [1 2 3 4 5])

; examplify map usage, compare with Java/JS
(map square numbers)

; filter is for removing things from a collection, compare with Java/JS
(filter even? numbers)

; combine map and filter
(map square (filter even? numbers))

; reduce works like this, compare with Java/JS
(reduce + [1 2 3])

; here is our solution:
(reduce + (map square (filter even? numbers)))

; perhaps exemplify with thread last?
(->> (filter even? numbers)
     (map square)
     (reduce +))

;;; We cannot forget maps

; create a new map, compare with hash map in Java
(def mario {:name "Mario"
            :occupation "Plumber"
            :nationality "Italian"
            :birthplace "Yoshi's Island"})

; get values
(get mario :occupation)
(:name mario)

; extract parts of the map
(select-keys mario [:name :nationality])

; add a new key to the map
(assoc mario :brother "Luigi")

;;; If there is time - lazy sequences

; range is nice to start with
(range)

; lazy seq example with list comprehension
(def even-numbers
  (for [x (range)
        :when (even? x)]
    x))

(take 10 even-numbers)

(->> even-numbers
     (drop 10)
     (take 10))
