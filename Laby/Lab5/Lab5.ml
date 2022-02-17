type 'a llist = LNil | LCons of 'a * (unit -> 'a llist);;

let rec lfrom k = LCons (k, function () -> lfrom (k + 1));;

let rec toLazyList xs =
    match xs with
        []   -> LNil
      | h::t -> LCons(h, function () -> toLazyList t);;

let rec ltake (n, lxs) =
    match (n, lxs) with
          (0, _) -> []
        | (_, LNil) -> []
        | (n, LCons(x,xf)) -> x::ltake(n-1, xf());;

let rec buyTicket xs n =
    match (xs, n) with
    | ([], _) -> []
    | ((_, xsfunc) :: t, 1) -> (xsfunc(), xsfunc) :: t
    | (h :: t, n) -> h :: (buyTicket t (n - 1));;

let lazyPrices = [
("?", function () -> "Komputer1");
("?", function () -> "Komputer2");
("?", function () -> "Komputer3");
("?", function () -> "Komputer4");
("?", function () -> "Komputer5")
];;

buyTicket [] 1 = [];;
buyTicket lazyPrices 1;;
buyTicket (buyTicket lazyPrices 1) 3;;