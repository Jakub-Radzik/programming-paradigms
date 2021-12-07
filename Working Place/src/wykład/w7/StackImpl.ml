module Stack : STACK_FUN =
    struct
        type 'a t = EmptyStack | Push of 'a * 'a t
        exception Empty of string
        let create() = EmptyStack
        let push(e,s) = Push(e,s)
        let top = function
                Push(e,_) -> e
                | EmptyStack -> raise (Empty "module Stack: top")
        let pop = function
                Push(_,s) -> s
                | EmptyStack -> EmptyStack
        let isEmpty s = s = EmptyStack
    end;;