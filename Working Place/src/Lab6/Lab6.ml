(* Jakub Radzik *)
(* Zadanie 1 *)
let (+=) l r =
    if Array.length l <> Array.length r then invalid_arg "Vectors must have the same length"
    else
        let i = ref 0
        in begin
            while !i < Array.length l do
                l.(!i) <- (l.(!i) + r.(!i));
                i := !i + 1
            done;
        end

let v = [| 1; 2; 3; 4; 5; 6; 7; 8; 9 |];;
let u = [| 9; 8; 7; 6; 5; 4; 3; 2; 1 |];;
let k = [| |];;
let g = [| |];;
v += u;;
v;;
k += g;;
k;;
g += v;;