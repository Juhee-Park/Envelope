using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class clickEvent : MonoBehaviour
{ 
    private RaycastHit hit;
    bool isPickUp; //열쇠 얻었는지에 대한 상태

    // Update is called once per frame
    void Update()
    {

        //물체 클릭 할 경우. 
        if (Input.GetMouseButtonDown(0))
        {

            //마우스 포지션 취득해서 대입
            Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);

            //마우스 포지션에 ray 던져서 물체 인식 시 hit에 넣음.
            if (Physics.Raycast(ray, out hit))
            {

                //클릭한 게임 오브젝트 확인용 로그 찍기
                Debug.Log(hit.transform.gameObject.name);

                //상호작용할 오브젝트_ 이름으로 인식 (열쇠는 Key라 가정.)
                if (hit.transform.gameObject.name == "Key")
                {   
                    Debug.Log("click Key");
                    
                    //먹은 상태로 변경.
                    isPickUp = true;
                    
                    //상호작용할 코드 주입.



                    //먹은 아이템 화면 상 삭제.
                    //Destroy(hit.transform.gameObject)

                }
                //버튼을 누를 경우 ~ 상호작용. 오브젝트 이름에 button이 있을 경우.
                else if (hit.transform.gameObject.name.Contains("button"))
                {
                    //상호작용할 코드 주입.  
                    Debug.Log("click button");

                }
                else
                {
                    //그 외 클릭 이벤트. 
                }

            }
        }
    }
}
