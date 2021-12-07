module StackMachine =
struct
    type t = { mutable l: float option list }
    exception DivisionByZero of string
    exception TooFewArguments of string

    let init () = { l = [None]}

    type instruction = Rst | LoadF of float | LoadI of int | Cpy | Add | Sub | Mul | Div

    let execute_instruction (inst, cop, n) =
        match inst with
        | Rst -> cop.l <- [None]
        | LoadF(f) -> cop.l <- (Some f) :: cop.l
        | LoadI(i) -> cop.l <- (Some (float_of_int i)) :: cop.l
        | Cpy -> begin
        	        match cop.l with
                    | Some(a) :: _ -> cop.l <- (Some a) :: cop.l
                    | _ -> raise (TooFewArguments ("Cpy: "^(string_of_int n)^". instruction on the list"))
                 end
        | Add -> begin
                    match cop.l with
                    | Some(a) :: Some(b) :: t -> cop.l <- (Some (a +. b)) :: t
                    | _ -> raise (TooFewArguments ("Add: "^(string_of_int n)^". instruction on the list"))
                 end
        | Sub -> begin
                    match cop.l with
                    | Some(a) :: Some(b) :: t -> cop.l <- (Some (a -. b)) :: t
                    | _ -> raise (TooFewArguments ("Sub: "^(string_of_int n)^". instruction on the list"))
                 end
        | Mul -> begin
                    match cop.l with
                    | Some(a) :: Some(b) :: t -> cop.l <- (Some (a *. b)) :: t
                    | _ -> raise (TooFewArguments ("Mul: "^(string_of_int n)^". instruction on the list"))
                 end
        | Div -> begin
                    match cop.l with
                    | Some(a) :: Some(b) :: t when b = 0.0 -> raise (DivisionByZero ("Div: "^(string_of_int n)^". instruction on the list"))
                    | Some(a) :: Some(b) :: t -> cop.l <- (Some (a /. b)) :: t
                    | _ -> raise (TooFewArguments ("Div: "^(string_of_int n)^". instruction on the list"))
                 end

    let result cop =
        match cop.l with
            | h :: t -> h
            | _ -> failwith "Implementation error"

    let execute (instl, cop) =
        begin
            let rec execute_iter (instl, cop, n) =
                   match instl with
                   | h :: t -> begin
                        execute_instruction(h, cop, n);
                        execute_iter(t, cop, n + 1)
                   end
                   | _ -> ()
           in execute_iter(instl, cop, 1)
        end

end;;


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
(*
let t = StackMachine.init();;
StackMachine.result(t);;
StackMachine.execute_instruction(StackMachine.LoadF 1.0, t, 1);;
StackMachine.execute_instruction(StackMachine.LoadF 2.0, t, 1);;
StackMachine.execute_instruction(StackMachine.LoadF 3.0, t, 1);;
StackMachine.execute_instruction(StackMachine.LoadF 4.0, t, 1);;
StackMachine.execute_instruction(StackMachine.LoadF 5.0, t, 1);;
StackMachine.execute_instruction(StackMachine.Add, t, 1);;
StackMachine.execute_instruction(StackMachine.Sub, t, 1);;
StackMachine.execute_instruction(StackMachine.Cpy, t, 1);;
StackMachine.execute_instruction(StackMachine.LoadI 1, t, 1);;
StackMachine.execute_instruction(StackMachine.Mul, t, 1);;
StackMachine.execute_instruction(StackMachine.Div, t, 1);;
StackMachine.execute_instruction(StackMachine.LoadF 0.0, t, 1);;
StackMachine.execute_instruction(StackMachine.LoadF 1.0, t, 1);;
StackMachine.execute_instruction(StackMachine.Rst, t, 1);;
t;;
*)

module Coprocessor: COPROCESSOR = StackMachine;;

let t = Coprocessor.init();;
Coprocessor.execute([Coprocessor.LoadF 1.0; Coprocessor.LoadF 2.0; Coprocessor.Add], t);;
Coprocessor.result(t);;
Coprocessor.execute([Coprocessor.LoadF 3.0; Coprocessor.Sub], t);;
Coprocessor.result(t);;
try Coprocessor.execute([Coprocessor.LoadF 1.0; Coprocessor.Div], t) with
Coprocessor.DivisionByZero m -> print_string (m);;
Coprocessor.result(t);;
Coprocessor.execute([Coprocessor.LoadI 2; Coprocessor.Mul], t);;
Coprocessor.result(t);;
Coprocessor.execute([Coprocessor.Cpy], t);;
Coprocessor.result(t);;
Coprocessor.execute([Coprocessor.Rst], t);;
Coprocessor.result(t);;