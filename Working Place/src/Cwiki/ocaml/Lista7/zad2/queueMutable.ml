type 'a t = {
    mutable queue: 'a option array;
    mutable f:int; mutable r:int; mutable s:int}

exception Empty of string

exception Full of string

let empty size = { queue = Array.make (size) None;
    f = 0; r = 0; s = size}

let isFull q = q.r - q.f = -1 || q.r - q.f = Array.length q.queue;;

let isEmpty q = q.r = q.f;;
let inc v q = if v = q.s then 0 else v+1;;

let enqueue (v,q) =
    if isFull q then raise (Full "Full queue")
    else ( q.queue.(q.r)<- Some v; q.r <- (inc q.r q));;

let dequeue q =
    if isEmpty q then () else q.f <- (inc q.f q);;

let first q =
    if isEmpty q then raise (Empty "Empty queue")
    else match q.queue.(q.f) with
        | None -> failwith "Unexpected Error"
        | Some v -> v;;
