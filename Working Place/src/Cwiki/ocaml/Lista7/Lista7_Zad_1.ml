(*Jakub Radzik*)

(*Given module type*)
module type QUEUE_FUN =
sig
 type 'a t
 exception Empty of string
 val empty: unit -> 'a t
 val enqueue: 'a * 'a t -> 'a t
 val dequeue: 'a t -> 'a t
 val first: 'a t -> 'a
 val isEmpty: 'a t -> bool
end;;

(*a - list*)
module Queue_1 : QUEUE_FUN =
	struct
		type 'a t = 'a list
		exception Empty of string
		let empty() = [];;
		let enqueue (elem,queue) = queue @ [elem];;

		let dequeue = function
			| [] -> []
			| h::t -> t;;

		let first = function
			| [] -> raise (Empty "queue empty")
			| h::t -> h;;

		let isEmpty q = q = [];;
	end;;

(*tests*)

let a = Queue_1.enqueue(1,Queue_1.empty());;
let a = Queue_1.enqueue(2, a);;
let a = Queue_1.enqueue(3, a);;
Queue_1.first(a) = 1;;

let a = Queue_1.dequeue(a);;
Queue_1.first(a) = 2;;

let a = Queue_1.dequeue(a);;
Queue_1.first(a) = 3;;


(*b - pair of list*)
module Queue_2 : QUEUE_FUN =
	struct
		type 'a t = 'a list * 'a list
		exception Empty of string
		let empty() = ([],[]);;

		let swap = function
			| ([], yl) -> (List.rev yl,[])
			| q -> q;;

        (* 2nd list:  (xl, [y1; y2; ...; yn]) -> (xl, [y;y1; y2; ...; yn]) *)
		let enqueue (v,(x,y)) = swap (x,v::y);;

        (*1st list: ([x1; x2; ...; xm], yl) -> ([x2; ...; xm], yl)*)
		let dequeue = function
			| ([],_) -> ([],[])
			| (h::t,yl) -> swap (t,yl);;

		let first = function
			| ([],_) -> raise (Empty "queue empty")
			| (h::t,yl) -> h;;

		let isEmpty q = fst q = [];;
	end;;

(*tests*)

let b = Queue_2.enqueue(1,Queue_2.empty());;
let b = Queue_2.enqueue(2, b);;
let b = Queue_2.enqueue(3, b);;
Queue_2.first(b) = 1;;

let b = Queue_2.dequeue(b);;
Queue_2.first(b) = 2;;

let b = Queue_2.dequeue(b);;
Queue_2.first(b) = 3;;
