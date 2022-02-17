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

let a1 = [| 5; 5; 5; 5; 5; 5; 5; 5; 5 |];;
let a2 = [| 9; 8; 7; 6; 5; 4; 3; 2; 1 |];;
let a3 = [| |];;
let a4 = [| |];;
a1 += a2;;
a1;;
a3 += a4;;
a3;;
a4 += a1;;