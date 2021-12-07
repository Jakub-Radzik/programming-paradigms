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
module Queue : QUEUE_FUN =
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

(*b - pair of list*)
module Queue : QUEUE_FUN =
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