let revNComp f n x =
    let rec revNCompInside (f, n, x, list) =
        if n <= 0 then []
        else if n = 1 then x::list
        else revNCompInside (f, n-1, f x, x::list)
    in revNCompInside (f, n, x, []);;

let twice x = x * 2;;
let triple x = x * 3;;
revNComp twice 10 5 = [2560; 1280; 640; 320; 160; 80; 40; 20; 10; 5];;
revNComp triple 5 3 = [243; 81; 27; 9; 3];;

let area (a, b) f n =
    let rec createList(count) =
        if count < n then count :: createList(count+1)
        else []
   in let (xs, diff) = (createList(1), ((b -. a) /. float(n-1)) ) in
   List.fold_left (+.) 0. (List.map (fun (x) -> f(a +. diff *. float(x) ) *. diff) xs);;

area (1.0, 4.0) (fun x -> x *. x) 2;;
area (0.0, 1.0) (fun x -> x *. x *. x) 1000;;
