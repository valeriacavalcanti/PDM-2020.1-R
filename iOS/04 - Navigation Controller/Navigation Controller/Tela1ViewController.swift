//
//  ViewController.swift
//  Navigation Controller
//
//  Created by Valéria Cavalcanti on 01/12/20.
//

import UIKit

class Tela1ViewController: UIViewController {

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if (segue.identifier == "tela1_tela2"){
            let t2vc = segue.destination as! Tela2ViewController
            t2vc.mensagem = "Funciona 1 2"
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        print("Tela1 - viewDidLoad")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        print("Tela1 - viewWillAppear")
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(true)
        print("Tela1 - viewDidAppear")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(true)
        print("Tela1 - viewWillDisappear")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(true)
        print("Tela1 - viewDidDisappear")
    }
}

