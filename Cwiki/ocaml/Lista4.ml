(*Jakub Radzik*)

(*1*)
let f1 x y z = x y z;;
(*
val f1 : ('a -> 'b -> 'c) -> 'a -> 'b -> 'c = <fun>
*)

let f2 x y = function z -> x::y;;
(*
val f2 : 'a -> 'a list -> 'b -> 'a list = <fun>
*)

(* 2 *)
let rec f x = f x;;
(*
val f : 'a -> 'b = <fun>
*)

(*TREES*)
type 'a bt = Empty | Node of 'a * 'a bt * 'a bt;;

let tt = Node(1,
  Node(2,
    Node(4, Empty, Empty),
    Empty),
  Node(3,
    Node(5, Empty,
      Node(6, Empty, Empty)),
    Empty));;

let myTree = Node(1,
  Node(2,
    Node(4,
      Node(9, Empty, Empty),
      Node(10, Empty, Empty)
    )
    , Empty
  ),
  Node(10,
    Node(11, Empty, Empty),
    Node(12, Empty, Empty)
  )
);;

(* TASK 3 *)
let breadthBT tree =
	let rec breadth treeList =
	    match treeList with
		| [] -> []
		| Empty::tail -> breadth tail
		| Node(value, left, right)::tail -> value::breadth(tail @ (left::right::[]))
	in breadth [tree];;

breadthBT tt = [1; 2; 3; 4; 5; 6];;
breadthBT Empty = [];;
breadthBT myTree = [1; 2; 10; 4; 11; 12; 9; 10];;

(*4 a*)

let internalBT tree =
  let rec inter t acc = match t with
  	| Empty -> failwith "empty tree"
  	| Node(value,Empty,Empty) -> acc
  	| Node(value,left,Empty) -> acc + (inter left (acc+1))
  	| Node(value,Empty,right) -> acc + (inter right (acc+1))
  	| Node(value,right,left) -> acc + (inter right (acc+1)) + (inter left (acc+1))
	in inter tree 0;;

internalBT tt = 9;;
internalBT myTree = 14;;
(*internalBT Empty;; wyjątek rzucany *)

(*4 b*)

let externalBT tree =
	let rec ext t acc = match t with
		| Empty -> acc
		| Node(_,Empty,Empty) -> 2*(acc+1)
		| Node(_,left,Empty) -> (ext left (acc+1)) + acc + 1
		| Node(_,Empty,right) -> acc+1 + (ext right (acc+1))
		| Node(_,left,right) -> (ext left (acc+1)) + (ext right (acc+1))
	in ext tree 0;;

externalBT tt = 21;;
externalBT myTree = 30;;

(* TASK 5 *)

type 'a graph = Graph of ('a -> 'a list);;

let g = Graph(function
	| 0 -> [3]
	| 1 -> [0;2;4]
	| 2 -> [1]
	| 3 -> []
	| 4 -> [0;2]
	| n -> failwith("node "^string_of_int n^" does not exist")
	);;

let depthSearch (Graph graph) n =
  let rec search visited = function
    [] -> []
    | h::t -> if List.mem h visited then search visited t
    else h::search (h::visited) (graph h @ t)
  in search [] [n];;


depthSearch g 4 = [4; 0; 3; 2; 1];;
depthSearch g 2 = [2; 1; 0; 3; 4];;
depthSearch g 1 = [1; 0; 3; 2; 4];;