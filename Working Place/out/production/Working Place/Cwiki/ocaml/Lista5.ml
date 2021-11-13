(* Jakub Radzik *)

(*definicja list leniwych*)

type 'a llist = LNil | LCons of 'a * 'a llist Lazy.t;;

let rec lfrom k = LCons (k, lazy (lfrom (k+1)));;

let rec ltake = function
      (0, _) -> []
    | (_, LNil) -> []
    | (n, LCons(x,lazy xs)) -> x::ltake(n-1,xs);;

(*1*)
let lrepeat k ll =
    if k < 1
        then failwith "Liczba powtorzen mniejsza niz 1"
    else
        let rec helper (rpts, rest) =
            match (rpts, rest) with
                (_, LNil) -> LNil
              | (0, LCons(_, lazy tl)) -> helper(k, tl)
              | (_, LCons(hd, _)) -> LCons(hd, lazy (helper(rpts - 1, rest)))
        in helper (k, ll);;


(*(* 2 *)*)

(*let lfib =*)
(*    let rec lfibIn(p, n) =*)
(*        LCons(p+n, lazy(lfibIn(n, p+n))) in*)
(*    LCons(1, lazy(LCons(1, lazy(lfibIn(1, 1)))));;*)

(*ltake(15,lfib) = [1; 1; 2; 3; 5; 8; 13; 21; 34; 55; 89; 144; 233; 377; 610];;*)
(*ltake(3,lfib)= [1; 1; 2];;*)
(*ltake(1,lfib) = [1];;*)
(*ltake(0,lfib) = [];;*)

(* 3 *)

type 'a lBT = LEmpty | LNode of 'a * (unit ->'a lBT) * (unit -> 'a lBT) ;;

let rec lTree n = LNode(n,(fun() -> lTree (2*n)),(fun() -> lTree (2*n+1)));;

let lBreadth ltree =
  let rec breadthHelper = function
      [] -> LNil
      | LEmpty::t -> breadthHelper t
      | LNode(v, l, r)::t -> LCons(v, lazy (breadthHelper(t @ [l() ; r()])))
    in breadthHelper [ltree];;


lBreadth(lTree(1));;
ltake(20, lBreadth(lTree(1))) = [1; 2; 3; 4; 5; 6; 7; 8; 9; 10; 11; 12; 13; 14; 15; 16; 17; 18; 19; 20];;
ltake(20, lBreadth(LEmpty)) = [];;
ltake(10, lBreadth(lTree(3))) = [3; 6; 7; 12; 13; 14; 15; 24; 25; 26];;