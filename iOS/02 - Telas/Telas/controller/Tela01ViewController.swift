//
//  ViewController.swift
//  Telas
//
//  Created by Valéria Cavalcanti on 10/11/20.
//

import UIKit

class Tela01ViewController: UIViewController {


    @IBAction func tela03(_ sender: Any) {
        let t3vc = self.storyboard?.instantiateViewController(identifier: "tela03") as! Tela03ViewController
        t3vc.mensagem = "Funciona mesmo!"
        self.present(t3vc, animated: true, completion: nil)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "tela01_tela02"){
            let t2vc = segue.destination as! Tela02ViewController
            t2vc.mensagem = "Funciona!"
        }
    }
    
}

