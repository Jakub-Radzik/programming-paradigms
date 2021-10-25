let revNComp f n x =
    let rec revNCompInside (f, n, x) =
        if n <= 0 then []
        else if n = 1 then [x]
        else x :: revNCompInside (f, n-1, f x)
    in List.rev (revNCompInside (f, n, x));;

let twice x = x * 2;;
let triple x = x * 3;;
revNComp twice 10 5 = [2560; 1280; 640; 320; 160; 80; 40; 20; 10; 5];;
revNComp triple 5 3 = [243; 81; 27; 9; 3];;

let rec calculate (a, b, n, start, i) =

    if i = 1 then (a, 0.) :: (calculate (a +. ((b -. start) /. float(n - 1)), b, n, start, i + 1))
    else if (i < n) then (a, (b -. start) /. float(n - 1)) :: (calculate (a +. ((b -. start) /. float(n - 1)), b, n, start, i + 1))
    else [(b, ((b -. start) /. float(n - 1)))];;

let a = fun (x, y) -> f(x) *. y;;

let area (a, b) f n =
    let xs = calculate(a, b, n, a, 1) in List.fold_left (+.) 0. (List.map (a) xs);;

area (1.0, 4.0) (fun x -> x *. x) 2;;