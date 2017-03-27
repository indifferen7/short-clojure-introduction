;;; 1. First steps

; Start with the most basic example.
(println "Hello world!")
; Reflect on parentheses placement w.r.t languages like Java.
; Explain that it's a list with two items and what those items are.
; In Clojure, the evaluation of a list means that the first item will be
; called, and the remaining items will constitute arguments to that call.

; What happens if we evaluate this?
(1 2 3)
; What went wrong? Is 1 callable? No!

; More examples of calls. We do not dive into a discussion of symbols here.
; Keep it simple.
(+ 1 2)
(+ 1 2 3)

; Exemplify nested expressions.
(+ 1 2 (- 4 1))



;;; 2. Java interoperability (https://clojure.org/reference/java_interop)

; Show the close connection with Java by evaluating this:
(type "foo")

; We can call instance methods via the dot operator.
(.length "foo")

; Sometimes there is an equivalent Clojure function to use.
(count "foo")

; There are tons more to say about this subject, but that's for another day.


;;; 3. Vars and functions

; Create a Var. Do not explain in detail what a Var is. Keep it simple.
; A mutable storage location that can be referred to. Perhaps a comparison 
; with variables in other languages can be made to give some reference.
(def foo "bar")

; Show the value of foo in your REPL.
foo

; Show an example of an anonymous function and that functions in Clojure 
; are first-class. Perhaps compare the structure of fn below with anonymous 
; functions in JavaScript for reference (https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions).
; Open question: what does the function do?
(def anonymous
  (fn [n] (* n n)))

; Show the shorthand notation for anonymous functions. Perhaps compare the 
; syntactic sugar with arrow functions in e.g. JavaScript (https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions).
(def shorthand #(* %1 %1))

; Show how the above function can be defined as a named function using defn.
(defn square
  "Squares the provided number"
  [n]
  (* n n))

; Give an example of the documentation facilities accessible via the REPL.
(doc square)



;;; 4. Exemplify map, filter and reduce in Clojure

; Explain that it's time to talk about how map, filter and reduce 
; works in Clojure. Perhaps explain that these are common tools when 
; working with collections in functional programming.

; For these examples we introduce a vector. Explain that it's a sequential
; collection like the list but more popular.
(def numbers [1 2 3 4 5])

; Show how we can map our square function to the vector of numbers above.
(map square numbers)
; Compare with map in e.g. Java or JavaScript. Stress that a new sequence is 
; returned when evaluated and that the core data structures in clojure are 
; immutable. If you want to you can go on and talk about persistent data structures here.

; Show how collections can be filtered using a predicate. Again, compare with 
; other known languages for the listeners, e.g. JavaScript or Java. Explain the 
; '?' in the predicate. Again, stress that a new sequence is returned here.
(filter even? numbers)

; Show how the two above expressions can be combined.
(map square (filter even? numbers))

; Explain reduce a bit by a simple example. Again, compare with other known languages 
; for the listeners, e.g. JavaScript or Java. Again, stress that a new sequence is returned here.
(reduce + [1 2 3])

; Combine all three of the above. What does the function do?
(reduce + (map square (filter even? numbers)))

; Perhaps exemplify some syntactic sugar with threading.
(->> (filter even? numbers)
     (map square)
     (reduce +))

; Compare the two expressions above. Which is more readable?



;;; 5. We cannot forget the Map

; Create a sample map data structure like the one below. Compare with e.g. HashMap in Java
; or objects in JavaScript for reference. Stress that they're immutable. Mention what keywords are.
(def mario {:name "Mario"
            :occupation "Plumber"
            :nationality "Italian"
            :birthplace "Yoshi's Island"})

; Show some ways to get values from maps.
(get mario :occupation)
(:name mario)

; Show how we can extract a subset of a map. Stress that we get a new map back.
(select-keys mario [:name :nationality])

; Show how new entries can be added to a map. Stress that they're not really added - a new map 
; is returned with the new key/value pair.
(assoc mario :brother "Luigi")



;;; 6. Time is probably up by now, but here is some extra material just in case. Lazy sequences!

; A range is a great lazy sequence to use for demonstration purposes. Say that in lazy sequences
; the next value is evaluated when needed.
(range)
; In e.g. Light Table the above yields output when evaluated inline, but if the REPL doesn't give
; any output you can instead invoke the following to get visual effect for the spectators:
(map println (range))

; The for list comprehension is another lazy sequence worth demonstrating. Here is an example that 
; creates a lazy sequence for all even numbers. Explain that one way to think about the binding is 
; that values are drawn from right to left, e.g. from (range) to x. 
(def even-numbers
  (for [x (range)
        :when (even? x)]
    x))

; Show some examples of how we can use our new lazy sequence, like so:
(take 10 even-numbers)

; And as a final example we can repeat how threading works. Perhaps someone now can explain what 
; the following does:
(->> even-numbers
     (drop 10)
     (take 10))

; The end!
