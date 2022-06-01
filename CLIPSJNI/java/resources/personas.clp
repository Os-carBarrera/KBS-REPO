(deftemplate person
  (slot name)
  (slot gender)
  (slot age)
)

(deffacts personas
	(person (name jose) (gender male) (age 48))
	(person (name andrea) (gender female) (age 21))
	(person (name rosa) (gender female) (age 26))
)

(defrule ruleEdad (person (age ?a) (name ?n)) => (printout t "la edad de " ?n " es " ?a crlf))