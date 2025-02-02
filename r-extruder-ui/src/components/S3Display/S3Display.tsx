import React from "react";
import { S3KeyDisplayProps } from "../../utils/types";
import "./S3Display.scss";

const S3KeyDisplay: React.FC<S3KeyDisplayProps> = ({
  s3Key,
  copyToClipboard,
}) => {
  return (
    <div id={"S3KeyDisplay"} className="s3">
      {s3Key && (
        <>
          <p>Your S3 key for download: </p>
          <input type="text" value={s3Key} readOnly />
          <button type="button" onClick={copyToClipboard}>
            <svg
              fill="#ffffff"
              xmlns="http://www.w3.org/2000/svg"
              viewBox="0 0 52 52"
              enableBackground="new 0 0 52 52"
              xmlSpace="preserve"
              stroke="#ffffff"
            >
              <g id="SVGRepo_bgCarrier" strokeWidth="0"></g>
              <g
                id="SVGRepo_tracerCarrier"
                strokeLinecap="round"
                strokeLinejoin="round"
              ></g>
              <g id="SVGRepo_iconCarrier">
                <g>
                  <path d="M17.4,11.6h17.3c0.9,0,1.6-0.7,1.6-1.6V6.8c0-2.6-2.1-4.8-4.7-4.8h-11c-2.6,0-4.7,2.2-4.7,4.8V10 C15.8,10.9,16.5,11.6,17.4,11.6z"></path>
                  <path d="M43.3,6h-1.6c-0.5,0-0.8,0.3-0.8,0.8V10c0,3.5-2.8,6.4-6.3,6.4H17.4c-3.5,0-6.3-2.9-6.3-6.4V6.8 c0-0.5-0.3-0.8-0.8-0.8H8.7C6.1,6,4,8.2,4,10.8v34.4C4,47.8,6.1,50,8.7,50h34.6c2.6,0,4.7-2.2,4.7-4.8V10.8C48,8.2,45.9,6,43.3,6z"></path>
                </g>
              </g>
            </svg>
          </button>
        </>
      )}
    </div>
  );
};

export default S3KeyDisplay;
