(*Jakub Radzik*)

(*a*)
module StackMachine =
struct
    type t = {
        mutable lx: float option list
    }

    exception DivisionByZero of string
    exception TooFewArguments of string

    let init () = {
        lx= [None]
    }

    type instruction = Rst | LoadF of float | LoadI of int | Cpy | Add | Sub | Mul | Div

    let execute_instruction (inst, coproc, n) =
        match inst with
        | Rst -> coproc.lx <- [None]
        | LoadF f -> coproc.lx <- Some f :: coproc.lx
        | LoadI i -> coproc.lx <- Some (float_of_int i) :: coproc.lx
        | Cpy -> begin
        	        match coproc.lx with
                    | Some a :: _ -> coproc.lx <- Some a :: coproc.lx
                    | _ -> raise (TooFewArguments ("Cpy: "^(string_of_int n)^". instruction on the list"))
                 end
        | Add -> begin
                    match coproc.lx with
                    | Some a :: Some b :: t -> coproc.lx <- Some (a +. b) :: t
                    | _ -> raise (TooFewArguments ("Add: "^(string_of_int n)^". instruction on the list"))
                 end
        | Sub -> begin
                    match coproc.lx with
                    | Some a :: Some b :: t -> coproc.lx <- Some (a -. b) :: t
                    | _ -> raise (TooFewArguments ("Sub: "^(string_of_int n)^". instruction on the list"))
                 end
        | Mul -> begin
                    match coproc.lx with
                    | Some a :: Some b :: t -> coproc.lx <- Some (a *. b) :: t
                    | _ -> raise (TooFewArguments ("Mul: "^(string_of_int n)^". instruction on the list"))
                 end
        | Div -> begin
                    match coproc.lx with
                    | Some a :: Some b :: t ->
                        begin
                        	if b = 0.0 then
                        	    raise (DivisionByZero ("Div: "^(string_of_int n)^". instruction on the list"))
                        	else
                        	    coproc.lx <- Some (a /. b) :: t
                        end
                    | _ -> raise (TooFewArguments ("Div: "^(string_of_int n)^". instruction on the list"))
                 end

    let result coproc =
        match coproc.lx with
            | h :: t -> h
            | _ -> failwith "Implementation error"

    let execute (instlist, coproc) =
        begin
            let rec execute_iter (instlist, coproc, n) =
                   match instlist with
                   | h :: t -> begin
                        execute_instruction(h, coproc, n);
                        execute_iter(t, coproc, n + 1)
                   end
                   | _ -> ()
           in execute_iter(instlist, coproc, 1)
        end

end;;

(*b*)
module type COPROCESSOR =
sig
    type  t
    type instruction = Rst | LoadF of float | LoadI of int | Cpy | Add | Sub | Mul | Div
    exception DivisionByZero of string
    exception TooFewArguments of string
    val init: unit -> t
    val result: t -> float option
    val execute: instruction list * t -> unit
end;;

(*c*)
module Coprocessor: COPROCESSOR = StackMachine;;

(*tests*)
let testCop = Coprocessor.init();;
Coprocessor.execute([Coprocessor.LoadF 420.; Coprocessor.LoadF 2137.; Coprocessor.LoadF 69.; Coprocessor.Add], testCop);;
Coprocessor.result(testCop);;
Coprocessor.execute([Coprocessor.LoadF 3.; Coprocessor.Sub], testCop);;
Coprocessor.result(testCop);;

try
    Coprocessor.execute([Coprocessor.LoadF 2213.; Coprocessor.Add; Coprocessor.LoadF 1.0; Coprocessor.Div], testCop)
with
    Coprocessor.DivisionByZero m -> print_string (m);;

Coprocessor.result(testCop);;
Coprocessor.execute([Coprocessor.LoadI 2; Coprocessor.Mul], testCop);;
Coprocessor.result(testCop);;
Coprocessor.execute([Coprocessor.Cpy], testCop);;
Coprocessor.result(testCop);;
Coprocessor.execute([Coprocessor.Rst], testCop);;
Coprocessor.result(testCop);;